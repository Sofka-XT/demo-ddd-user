package co.com.sofka.user.usecases;

import co.com.sofka.user.values.Email;

public interface SenderEmailService {
    void sendEmail(Email email, String body);
}
