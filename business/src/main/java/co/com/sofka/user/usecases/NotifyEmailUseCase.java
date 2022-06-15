package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.user.events.ChangedPasswordOfAccount;

import java.util.List;

public class NotifyEmailUseCase extends UseCase<TriggeredEvent<ChangedPasswordOfAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ChangedPasswordOfAccount> input) {
        var event = input.getDomainEvent();
        var service = getService(SenderEmailService.class).orElseThrow();

        service.sendEmail(event.getEmail(), "Se cambia el password de su cuenta");

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
