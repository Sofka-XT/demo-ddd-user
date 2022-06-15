package co.com.sofka.user.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.user.values.Category;
import co.com.sofka.user.values.Content;
import co.com.sofka.user.values.LessonId;
import co.com.sofka.user.values.LessonType;

public class LessonAdded extends DomainEvent {
    private final LessonId identity;
    private final Content content;
    private final Category category;
    private final LessonType lessonType;

    public LessonAdded(LessonId identity, Content content, Category category, LessonType lessonType) {
        super("user.LessonAdded");
        this.identity = identity;
        this.content = content;
        this.category = category;
        this.lessonType = lessonType;
    }

    public Category getCategory() {
        return category;
    }

    public Content getContent() {
        return content;
    }

    public LessonId getIdentity() {
        return identity;
    }

    public LessonType getLessonType() {
        return lessonType;
    }


}
