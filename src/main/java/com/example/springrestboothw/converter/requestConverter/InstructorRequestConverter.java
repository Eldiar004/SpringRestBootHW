package com.example.springrestboothw.converter.requestConverter;
import com.example.springrestboothw.dto.requests.InstructorRequest;
import com.example.springrestboothw.entities.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorRequestConverter {

    public Instructor convertRequestToInstructor(InstructorRequest instructorRequest){
        if (instructorRequest == null) {
            return null;
        }
        Instructor instructor = new Instructor();
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        return instructor;
    }

    public void updateInstructor(Instructor instructor,InstructorRequest instructorRequest){
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
    }
}
