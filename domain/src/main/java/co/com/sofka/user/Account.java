package co.com.sofka.user;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;
import co.com.sofka.user.values.Username;

public class Account extends Entity<Email> {
    protected Username username;
    protected Password password;

    public Account(Email email, Username username, Password password) {
        super(email);
        this.username = username;
        this.password = password;
    }

    public void changePassword(Password password){
        this.password = password;
    }

    public Username username() {
        return  username;
    }

    public Password password() {
        return  password;
    }

}
