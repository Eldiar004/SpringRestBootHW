package com.example.springrestboothw.service;
import com.example.springrestboothw.converter.requestConverter.InstructorRequestConverter;
import com.example.springrestboothw.dto.requests.InstructorRequest;
import com.example.springrestboothw.dto.responses.InstructorResponse;
import com.example.springrestboothw.entities.Instructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InstructorService {
    List<InstructorResponse> getAllInstructor();
    InstructorResponse saveInstructorByCourseId(Long courseId, InstructorRequest instructorRequest);
    void deleteInstructorById(Long id);
    InstructorResponse updateInstructor(Long instructorId,InstructorRequest instructorRequest);
    InstructorResponse assignInstructorToCourseById(Long courseId , Long instructorId);
    InstructorResponse getById(Long id);
}

