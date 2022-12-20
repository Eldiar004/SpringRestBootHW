package com.example.springrestboothw.service;

import com.example.springrestboothw.converter.responseConverter.StudentResponseConverter;
import com.example.springrestboothw.dto.requests.StudentRequest;
import com.example.springrestboothw.dto.responses.StudentResponse;
import com.example.springrestboothw.entities.Student;

import java.util.List;

public interface StudentService {
    StudentResponse getById(Long id);
    StudentResponse saveStudent(Long id, StudentRequest studentRequest);
    void deleteStudentById(Long id);
    List<StudentResponse> getAllStudent();
    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
    StudentResponse assignStudentToGroup(Long groupId, Long studentId);
}
