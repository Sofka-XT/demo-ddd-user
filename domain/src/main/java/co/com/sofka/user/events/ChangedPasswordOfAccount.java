package co.com.sofka.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;

public class ChangedPasswordOfAccount extends DomainEvent {
    private final Email email;
    private final Password password;

    public ChangedPasswordOfAccount(Email email, Password password) {
        super("user.ChangedPasswordOfAccount");
        this.email = email;
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }
}
