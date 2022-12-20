package com.example.springrestboothw.service.serviceImpl;
import com.example.springrestboothw.converter.requestConverter.StudentRequestConverter;
import com.example.springrestboothw.converter.responseConverter.StudentResponseConverter;
import com.example.springrestboothw.dto.requests.StudentRequest;
import com.example.springrestboothw.dto.responses.StudentResponse;
import com.example.springrestboothw.entities.Group;
import com.example.springrestboothw.entities.Student;
import com.example.springrestboothw.repository.GroupRepository;
import com.example.springrestboothw.repository.StudentRepository;
import com.example.springrestboothw.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;
    private final GroupRepository groupRepository;

    public StudentResponse saveStudent(Long id, StudentRequest studentRequest){
        Group group = groupRepository.findById(id).get();
        Student student = studentRequestConverter.convertRequestToInstructor(studentRequest);
        student.setGroup(group);
        repository.save(student);
        return studentResponseConverter.convertStudentToResponse(student);
    }
    public StudentResponse getById(Long id){
        Student student = repository.findById(id).get();
        return studentResponseConverter.convertStudentToResponse(student);
    }
    public void deleteStudentById(Long id){
        Student student = repository.findById(id).get();
        repository.delete(student);
    }

    public List<StudentResponse> getAllStudent(){
        return studentResponseConverter.viewAllResponses(repository.findAll());
    }

    public StudentResponse updateStudent(Long id, StudentRequest studentRequest){
        Student student = repository.findById(id).get();
        studentRequestConverter.updateInstructor(student,studentRequest);
        repository.save(student);
        return studentResponseConverter.convertStudentToResponse(student);
    }

    public StudentResponse assignStudentToGroup(Long groupId, Long studentId){
        Group group = groupRepository.findById(groupId).get();
        Student student = repository.findById(studentId).get();
        student.setGroup(group);
        repository.save(student);
        return studentResponseConverter.convertStudentToResponse(student);
    }
}
