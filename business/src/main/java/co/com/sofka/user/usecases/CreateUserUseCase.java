package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.user.User;
import co.com.sofka.user.command.CreateUserCommand;
import co.com.sofka.user.values.UserId;

public class CreateUserUseCase extends UseCase<RequestCommand<CreateUserCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateUserCommand> input) {
        var command = input.getCommand();
        var user = new User(new UserId(), command.getUsername(), command.getPassword(), command.getEmail());
        emit().onResponse(new ResponseEvents(user.getUncommittedChanges()));
    }
}
