package com.example.springrestboothw.service;

import com.example.springrestboothw.dto.requests.LessonRequest;
import com.example.springrestboothw.dto.responses.LessonResponse;
import com.example.springrestboothw.entities.Lesson;

import java.util.List;
public interface LessonService {
    LessonResponse getById(Long id);
    LessonResponse saveLessonByCourseId(Long id, LessonRequest lessonRequest);

    void deleteById(Long id);

    List<LessonResponse> getAllLesson();

    LessonResponse updateLesson(Long id, LessonRequest lessonRequest);

//    List<Lesson> getAllLessonByCourseId(Long id);
}

