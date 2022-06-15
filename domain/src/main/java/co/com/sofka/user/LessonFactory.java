package co.com.sofka.user;

import co.com.sofka.user.values.Category;
import co.com.sofka.user.values.Content;
import co.com.sofka.user.values.LessonId;
import co.com.sofka.user.values.LessonType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LessonFactory {

    private final Set<Lesson> lessons;
    private static LessonFactory instance;

    private LessonFactory(){
        lessons = new HashSet<>();
    }

    public static LessonFactory getInstance(){
        if(Objects.isNull(instance)){
            instance = new LessonFactory();
            return instance;
        }
        return instance;
    }

    public LessonFactory add(LessonId entityId, Content content, Category category, LessonType lessonType){
        lessons.add(new Lesson(entityId, content, category, lessonType));
        return this;
    }

    protected Set<Lesson> lessons() {
        return lessons;
    }
}
