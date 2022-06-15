package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.user.Student;
import co.com.sofka.user.command.CreateUserCommand;
import co.com.sofka.user.values.StudentId;

public class CreateStudentUseCase extends UseCase<RequestCommand<CreateUserCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateUserCommand> input) {
        var command = input.getCommand();
        var student = new Student(new StudentId(), command.getUsername(), command.getPassword(), command.getEmail());
        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
