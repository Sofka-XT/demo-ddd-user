package co.com.sofka.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;
import co.com.sofka.user.values.Username;

public class CreatedStudent extends DomainEvent {
    private final Username username;
    private final Password password;
    private final Email email;

    public CreatedStudent(Username username, Password password, Email email) {
        super("user.CreatedUser");
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Username getUsername() {
        return username;
    }


}
