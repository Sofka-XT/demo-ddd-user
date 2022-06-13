package co.com.sofka.user;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.user.events.ChangedFullname;
import co.com.sofka.user.events.ChangedPasswordOfAccount;
import co.com.sofka.user.events.ChangedRole;
import co.com.sofka.user.events.CreatedUser;
import co.com.sofka.user.values.*;

public class User extends AggregateEvent<UserId> {
    protected Account account;
    protected Fullname fullname;
    protected Rol rol;

    public User(UserId id, Username username, Password password, Email email) {
        super(id);
        subscribe(new UserChange(this));
        appendChange(new CreatedUser(username, password, email)).apply();
    }

    public void changeFullname(Fullname fullname){
        appendChange(new ChangedFullname(fullname)).apply();
    }

    public void changePasswordOfAccount(Email email, Password password){
        appendChange(new ChangedPasswordOfAccount(email, password)).apply();

    }

    public void changeRol(Rol rol){
        appendChange(new ChangedRole(rol)).apply();
    }


}
