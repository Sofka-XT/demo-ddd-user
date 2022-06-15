package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.user.events.ChangedPasswordOfAccount;
import co.com.sofka.user.values.Email;
import co.com.sofka.user.values.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyEmailUseCaseTest {

    @Mock
    SenderEmailService senderEmailService;

    @InjectMocks
    NotifyEmailUseCase useCase;

    @Test
    void enviarCorreo(){
        var event = new ChangedPasswordOfAccount(Email.of("alzategomez.raul@gmail.com"), new Password("ssss"));

        doNothing().when(senderEmailService).sendEmail(any(), any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(senderEmailService));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        Mockito.verify(senderEmailService).sendEmail(any(), any());
        Assertions.assertEquals(0, events.size());
    }
}