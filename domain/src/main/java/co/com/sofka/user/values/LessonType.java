package co.com.sofka.user.values;

import co.com.sofka.domain.generic.ValueObject;

public class LessonType implements ValueObject<LessonType.Types> {
    private final Types type;

    public LessonType(Types type) {
        this.type = type;
    }

    @Override
    public Types value() {
        return type;
    }

    public enum Types {
        VIDEO, TEXT, HTML
    }
}
