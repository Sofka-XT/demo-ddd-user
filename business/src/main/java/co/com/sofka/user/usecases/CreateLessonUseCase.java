package co.com.sofka.user.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.user.Student;
import co.com.sofka.user.command.CreateLessonCommand;

public class CreateLessonUseCase  extends UseCase<RequestCommand<CreateLessonCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateLessonCommand> input) {
        var command = input.getCommand();
        var student = Student.from(command.getStudentId(), repository().getEventsBy(command.getStudentId().value()));

        student.addLessons(command.getLessonFactory());

        emit().onResponse(new ResponseEvents(student.getUncommittedChanges()));
    }
}
