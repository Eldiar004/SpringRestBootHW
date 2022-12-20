package com.example.springrestboothw.converter.responseConverter;

import com.example.springrestboothw.dto.responses.CourseResponse;
import com.example.springrestboothw.entities.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CourseResponseConverter {

    public CourseResponse viewResponse(Course course){
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setId(course.getId());
        return courseResponse;
    }
    public List<CourseResponse> viewAllCourseResponses(List<Course> courses){
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course:courses) {
            courseResponses.add(viewResponse(course));
        }
        return courseResponses;
    }
}
