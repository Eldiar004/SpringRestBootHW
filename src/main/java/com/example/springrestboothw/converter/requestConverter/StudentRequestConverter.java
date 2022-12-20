package com.example.springrestboothw.converter.requestConverter;
import com.example.springrestboothw.dto.requests.InstructorRequest;
import com.example.springrestboothw.dto.requests.StudentRequest;
import com.example.springrestboothw.entities.Instructor;
import com.example.springrestboothw.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestConverter {

    public Student convertRequestToInstructor(StudentRequest studentRequest){
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        return student;
    }

    public void updateInstructor(Student student,StudentRequest studentRequest){
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
    }
}
