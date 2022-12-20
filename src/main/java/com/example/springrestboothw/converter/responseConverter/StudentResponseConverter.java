package com.example.springrestboothw.converter.responseConverter;
import com.example.springrestboothw.dto.responses.StudentResponse;
import com.example.springrestboothw.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseConverter {

    public StudentResponse convertStudentToResponse(Student student){
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setPhoneNumber(student.getPhoneNumber());
        studentResponse.setLastName(student.getLastName());
        return studentResponse;
    }
    public List<StudentResponse> viewAllResponses(List<Student> students){
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student:students) {
            studentResponses.add(convertStudentToResponse(student));
        }
        return studentResponses;
    }
}
