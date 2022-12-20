package com.example.springrestboothw.api;
import com.example.springrestboothw.dto.requests.LessonRequest;
import com.example.springrestboothw.dto.responses.LessonResponse;
import com.example.springrestboothw.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public List<LessonResponse> getAllLesson(){
        return lessonService.getAllLesson();
    }

    @PostMapping("/saveLes/{courseId}")
    public LessonResponse saveLesson(@PathVariable Long courseId,@RequestBody LessonRequest lessonRequest){
        return lessonService.saveLessonByCourseId(courseId,lessonRequest);
    }

    @PutMapping("/updateLes/{lessonId}")
    public LessonResponse updateLesson(@PathVariable Long lessonId,@RequestBody LessonRequest lessonRequest){
        return lessonService.updateLesson(lessonId,lessonRequest);
    }

    @DeleteMapping("/deleteLes/{lessonId}")
    public String deleteLesson(@PathVariable Long lessonId){
        lessonService.deleteById(lessonId);
        return "Lesson deleted!!";
    }
}
