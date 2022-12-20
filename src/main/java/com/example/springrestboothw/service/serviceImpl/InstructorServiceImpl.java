package com.example.springrestboothw.service.serviceImpl;
import com.example.springrestboothw.converter.requestConverter.InstructorRequestConverter;
import com.example.springrestboothw.converter.responseConverter.InstructorResponseConverter;
import com.example.springrestboothw.dto.requests.InstructorRequest;
import com.example.springrestboothw.dto.responses.InstructorResponse;
import com.example.springrestboothw.entities.Course;
import com.example.springrestboothw.entities.Instructor;
import com.example.springrestboothw.repository.CourseRepository;
import com.example.springrestboothw.repository.InstructorRepository;
import com.example.springrestboothw.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository repository;
    private final CourseRepository courseRepository;
    private final InstructorRequestConverter instructorRequestConverter;
    private final InstructorResponseConverter instructorResponseConverter;

    @Override
    public InstructorResponse getById(Long id) {
        Instructor instructor = repository.findById(id).get();
        return instructorResponseConverter.viewResponse(instructor);
    }

    public InstructorResponse saveInstructorByCourseId(Long courseId, InstructorRequest instructorRequest) {
        Course course = courseRepository.findById(courseId).get();
        Instructor instructor = instructorRequestConverter.convertRequestToInstructor(instructorRequest);
        instructor.setCourse(course);
        repository.save(instructor);
        return instructorResponseConverter.viewResponse(instructor);
    }

    public void deleteInstructorById(Long id){
        repository.deleteById(id);
    }

    public List<InstructorResponse> getAllInstructor(){
        List<Instructor> instructors = repository.findAll();
        return instructorResponseConverter.viewAllInstructorResponse(instructors);
    }

    public InstructorResponse updateInstructor(Long instructorId,InstructorRequest instructorRequest){
        Instructor instructor = repository.findById(instructorId).get();
        instructorRequestConverter.updateInstructor(instructor,instructorRequest);
        repository.save(instructor);
        return instructorResponseConverter.viewResponse(instructor);
    }

    public InstructorResponse assignInstructorToCourseById(Long courseId,Long instructorId){
        Course course = courseRepository.findById(courseId).get();
        Instructor instructor = repository.findById(instructorId).get();
        instructor.setCourse(course);
        return instructorResponseConverter.viewResponse(instructor);
    }

//    public List<Instructor> getAllInstructorByCourseId(Long id){
//        return repository.getInstructorByCourseId(id);
//    }
}
