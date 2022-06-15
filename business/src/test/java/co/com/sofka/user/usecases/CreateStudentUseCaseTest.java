package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.user.command.CreateUserCommand;
import co.com.sofka.user.events.CreatedStudent;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;
import co.com.sofka.user.values.Username;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateStudentUseCaseTest {

    @Test
    void createUser(){
        //arrange
        Username username = new Username("raulalzate");
        Password password = new Password("xxxxx");
        Email email = Email.of("alzategomez.raul@gmail.com");
        var command = new CreateUserCommand(username, password, email );
        var usecase = new CreateStudentUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CreatedStudent)events.get(0);
        Assertions.assertEquals("xxxxx", event.getPassword().value());
        Assertions.assertEquals("raulalzate", event.getUsername().value());
        Assertions.assertEquals("alzategomez.raul@gmail.com", event.getEmail().value());
    }
}