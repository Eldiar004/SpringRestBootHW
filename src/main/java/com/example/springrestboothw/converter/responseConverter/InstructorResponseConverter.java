package com.example.springrestboothw.converter.responseConverter;

import com.example.springrestboothw.dto.responses.InstructorResponse;
import com.example.springrestboothw.entities.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InstructorResponseConverter {

    public InstructorResponse viewResponse(Instructor instructor){
        if (instructor == null) {
            return null;
        }
        InstructorResponse instructorResponse = new InstructorResponse();
        instructorResponse.setId(instructor.getId());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setFirstName(instructor.getFirstName());
        instructorResponse.setLastName(instructor.getLastName());
        instructorResponse.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponse.setSpecialization(instructor.getSpecialization());
        return instructorResponse;
    }

    public List<InstructorResponse> viewAllInstructorResponse(List<Instructor>instructors){
        List<InstructorResponse> instructorResponses = new ArrayList<>();
        for (Instructor instructor:instructors) {
            instructorResponses.add(viewResponse(instructor));
        }
        return instructorResponses;
    }
}
