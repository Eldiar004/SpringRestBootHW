package com.example.springrestboothw.service;

import com.example.springrestboothw.dto.requests.CourseRequest;
import com.example.springrestboothw.dto.responses.CourseResponse;
import com.example.springrestboothw.entities.Course;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourseByCompanyId(Long companyId, CourseRequest course);
    void deleteCourseById(Long id);
    List<CourseResponse> getAllCourses();
    CourseResponse updateCourse(Long courseId, CourseRequest courseRequest);
    List<Course> getAllCourseByCompanyId(Long id);
    CourseResponse getById(Long id);
}
