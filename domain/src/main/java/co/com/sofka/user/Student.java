package co.com.sofka.user;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.events.*;
import co.com.sofka.user.values.*;

import java.util.List;
import java.util.Set;

public class Student extends AggregateEvent<StudentId> {
    protected Account account;
    protected Fullname fullname;
    protected Rol rol;
    protected Set<Lesson> lessons;


    public Student(StudentId id, Username username, Password password, Email email) {
        super(id);
        subscribe(new StudentChange(this));
        appendChange(new CreatedStudent(username, password, email)).apply();
    }

    private Student(StudentId studentId) {
        super(studentId);
        subscribe(new StudentChange(this));
    }

    public static Student from(StudentId studentId, List<DomainEvent> eventsBy) {
        var student = new Student(studentId);
        eventsBy.forEach(student::applyEvent);
        return student;
    }

    public void addLessons(LessonFactory lessonFactory){
        lessonFactory.lessons()
                .forEach(lesson ->
                        appendChange(
                                new LessonAdded(lesson.identity(),  lesson.content(), lesson.category(), lesson.lessonType())
                        ).apply()
                );
    }


    public void changeFullname(Fullname fullname){
        appendChange(new ChangedFullname(fullname)).apply();
    }

    public void changePasswordOfAccount(Email email, Password password){
        appendChange(new ChangedPasswordOfAccount(email, password)).apply();

    }

    public void changeRol(Rol rol){
        appendChange(new ChangedRole(rol)).apply();
    }


}
