package com.example.springrestboothw.converter.requestConverter;

import com.example.springrestboothw.dto.requests.CourseRequest;
import com.example.springrestboothw.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRequestConverter {

    public Course convertRequestToCourse(CourseRequest courseRequest){
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        return course;
    }
    public void update(Course course,CourseRequest courseRequest){
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
    }
}
