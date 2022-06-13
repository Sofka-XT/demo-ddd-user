package co.com.sofka.user;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.user.events.ChangedFullname;
import co.com.sofka.user.values.Rol;
import co.com.sofka.user.events.ChangedPasswordOfAccount;
import co.com.sofka.user.events.ChangedRole;
import co.com.sofka.user.events.CreatedUser;

public class UserChange extends EventChange {
    public UserChange(User user) {
        apply((CreatedUser event) -> {
            user.account = new Account(event.getEmail(), event.getUsername(), event.getPassword());
            user.rol = new Rol(Rol.Roles.CUSTOM);
            user.fullname = null;
        });

        apply((ChangedFullname event) -> {
            user.fullname = event.getFullname();
        });
        
        apply((ChangedRole event) -> {
            user.rol = event.getRol();
        });
        
        apply((ChangedPasswordOfAccount event) -> {
            if(!user.account.identity().equals(event.getEmail())){
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            user.account.changePassword(event.getPassword());
        });
    }
}
