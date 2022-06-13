package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject<Rol.Roles> {

    private final Roles rol;

    public Rol(Roles rol) {
        this.rol = Objects.requireNonNull(rol);
    }

    public Roles value() {
        return rol;
    }

    public enum Roles {
        ADMIN, CUSTOM, MASTER
    }
}
