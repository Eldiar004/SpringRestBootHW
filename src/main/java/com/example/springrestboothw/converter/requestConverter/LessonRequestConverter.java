package com.example.springrestboothw.converter.requestConverter;

import com.example.springrestboothw.dto.requests.LessonRequest;
import com.example.springrestboothw.entities.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestConverter {

    public Lesson convertRequestToLesson(LessonRequest lessonRequest){
        if (lessonRequest == null) {
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public void updateLesson(Lesson lesson,LessonRequest lessonRequest){
        lesson.setLessonName(lessonRequest.getLessonName());
    }
}
