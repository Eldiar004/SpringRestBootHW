package com.example.springrestboothw.service.serviceImpl;

import com.example.springrestboothw.converter.requestConverter.LessonRequestConverter;
import com.example.springrestboothw.converter.responseConverter.LessonResponseConverter;
import com.example.springrestboothw.dto.requests.LessonRequest;
import com.example.springrestboothw.dto.responses.LessonResponse;
import com.example.springrestboothw.entities.Course;
import com.example.springrestboothw.entities.Lesson;
import com.example.springrestboothw.repository.CourseRepository;
import com.example.springrestboothw.repository.LessonRepository;
import com.example.springrestboothw.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository repository;
    private final CourseRepository courseRepository;
    private final LessonRequestConverter lessonRequestConverter;
    private final LessonResponseConverter lessonResponseConverter;

    @Override
    public LessonResponse getById(Long id) {
        Lesson lesson = repository.findById(id).get();
        return lessonResponseConverter.viewResponse(lesson);
    }

    public LessonResponse saveLessonByCourseId(Long id, LessonRequest lessonRequest){
        Course course = courseRepository.findById(id).get();
        Lesson lesson = lessonRequestConverter.convertRequestToLesson(lessonRequest);
        lesson.setCourse(course);
        repository.save(lesson);
        return lessonResponseConverter.viewResponse(lesson);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<LessonResponse> getAllLesson(){
        List<Lesson> lessons = repository.findAll();
        return lessonResponseConverter.viewAllResponse(lessons);
    }

    public LessonResponse updateLesson(Long id, LessonRequest lessonRequest){
        Lesson lesson = repository.findById(id).get();
        lessonRequestConverter.updateLesson(lesson,lessonRequest);
        repository.save(lesson);
        return lessonResponseConverter.viewResponse(lesson);
    }

//    public List<Lesson> getAllLessonByCourseId(Long id){
//        return repository.getAllLessonById(id);
//    }
}
