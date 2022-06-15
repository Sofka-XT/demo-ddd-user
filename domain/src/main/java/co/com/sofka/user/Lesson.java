package co.com.sofka.user;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.user.values.Category;
import co.com.sofka.user.values.Content;
import co.com.sofka.user.values.LessonId;
import co.com.sofka.user.values.LessonType;

import java.util.Objects;

public class Lesson extends Entity<LessonId> {

    private Content content;
    private Category category;
    private LessonType lessonType;

    public Lesson(LessonId entityId,  Content content, Category category, LessonType lessonType) {
        super(entityId);
        this.content = content;
        this.category = category;
        this.lessonType = lessonType;
    }

    public void changeCategory(Category category){
        this.category = Objects.requireNonNull(category);
    }

    public void changeContent(Content content){
        this.content = Objects.requireNonNull(content);
    }

    public Category category() {
        return category;
    }

    public Content content() {
        return content;
    }

    public LessonType lessonType() {
        return lessonType;
    }
}
