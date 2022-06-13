package co.com.sofka.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.values.Rol;

public class ChangedRole extends DomainEvent {
    private final Rol rol;

    public ChangedRole(Rol rol) {
        super("user.ChangedRole");
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }
}
