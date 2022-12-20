package com.example.springrestboothw.api;

import com.example.springrestboothw.dto.requests.CourseRequest;
import com.example.springrestboothw.dto.responses.CourseResponse;
import com.example.springrestboothw.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public List<CourseResponse> getAllCourse(){
        return courseService.getAllCourses();
    }

    @PostMapping("/saveCourse/{companyId}")
    public String saveCourse(@PathVariable("companyId")Long id, @RequestBody CourseRequest courseRequest){
        courseService.saveCourseByCompanyId(id,courseRequest);
        return "Course with name:"+courseRequest.getCourseName()+" successfully created and saved!!";
    }

    @PutMapping("/updateCourse/{courseId}")
    public CourseResponse updateCourse(@PathVariable("courseId")Long id,@RequestBody CourseRequest courseRequest){
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id")Long id) {
        courseService.deleteCourseById(id);
        return "Course with id:"+id+"successfully deleted!!";
    }

    @GetMapping("/getCourseById/{courseId}")
    public CourseResponse getCourseById(@PathVariable Long courseId){
        return courseService.getById(courseId);
    }
//    @GetMapping("/getCourses/{companyId}")
//    public List<Course> getAllCoursesByCompanyId(@PathVariable("companyId")Long id){
//        return courseService.getAllCourseByCompanyId(id);
//    }
}
