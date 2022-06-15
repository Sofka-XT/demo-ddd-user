package co.com.sofka.user.values;

import co.com.sofka.domain.generic.Identity;

public class LessonId extends Identity {
    private LessonId(String value) {
        super(value);
    }

    public LessonId(){ }

    public static LessonId of(String value) {
        return new LessonId(value);
    }
}
