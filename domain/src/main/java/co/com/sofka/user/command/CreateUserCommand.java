package co.com.sofka.user.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;
import co.com.sofka.user.values.Username;

public class CreateUserCommand extends Command {
    private final Username username;
    private final Password password;
    private final Email email;

    public CreateUserCommand(Username username, Password password, Email email){
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
