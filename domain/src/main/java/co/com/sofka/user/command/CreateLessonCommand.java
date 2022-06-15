package co.com.sofka.user.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.user.LessonFactory;
import co.com.sofka.user.values.StudentId;

public class CreateLessonCommand extends Command {
    private final LessonFactory lessonFactory;
    private final StudentId studentId;

    public CreateLessonCommand(LessonFactory lessonFactory, StudentId studentId) {
        this.lessonFactory = lessonFactory;
        this.studentId = studentId;
    }

    public LessonFactory getLessonFactory() {
        return lessonFactory;
    }

    public StudentId getStudentId() {
        return studentId;
    }
}
