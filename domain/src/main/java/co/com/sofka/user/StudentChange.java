package co.com.sofka.user;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.user.events.*;
import co.com.sofka.user.values.Rol;

import java.util.HashSet;

public class StudentChange extends EventChange {
    public StudentChange(Student student) {
        apply((CreatedStudent event) -> {
            student.account = new Account(event.getEmail(), event.getUsername(), event.getPassword());
            student.rol = new Rol(Rol.Roles.CUSTOM);
            student.fullname = null;
            student.lessons = new HashSet<>();
        });

        apply((ChangedFullname event) -> {
            student.fullname = event.getFullname();
        });
        
        apply((ChangedRole event) -> {
            student.rol = event.getRol();
        });
        
        apply((ChangedPasswordOfAccount event) -> {
            if(!student.account.identity().equals(event.getEmail())){
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            student.account.changePassword(event.getPassword());
        });

        apply((LessonAdded event) -> {
            student.lessons.add(new Lesson(event.getIdentity(), event.getContent(), event.getCategory(), event.getLessonType()));
        });
    }
}
