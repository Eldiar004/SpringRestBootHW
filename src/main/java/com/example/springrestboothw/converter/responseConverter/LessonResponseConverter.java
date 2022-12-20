package com.example.springrestboothw.converter.responseConverter;

import com.example.springrestboothw.dto.responses.LessonResponse;
import com.example.springrestboothw.entities.Lesson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonResponseConverter {

    public LessonResponse viewResponse(Lesson lesson){
        if (lesson == null) {
            return null;
        }
        LessonResponse lessonResponse = new LessonResponse();
        lessonResponse.setLessonName(lesson.getLessonName());
        return lessonResponse;
    }
    public List<LessonResponse> viewAllResponse(List<Lesson>lessons){
        List<LessonResponse> lessonResponses = new ArrayList<>();
        for (Lesson lesson:lessons) {
            lessonResponses.add(viewResponse(lesson));
        }
        return lessonResponses;
    }
}
