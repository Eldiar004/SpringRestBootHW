package com.example.springrestboothw.api;
import com.example.springrestboothw.dto.requests.StudentRequest;
import com.example.springrestboothw.dto.responses.StudentResponse;
import com.example.springrestboothw.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    @GetMapping("/students")
    public List<StudentResponse> getAllStudent(){
        return service.getAllStudent();
    }

    @PostMapping("/saveStud/{groupId}")
    public StudentResponse saveStudent(@PathVariable Long groupId,@RequestBody StudentRequest studentRequest){
        return service.saveStudent(groupId, studentRequest);
    }

    @DeleteMapping("/deleteStud/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        service.deleteStudentById(studentId);
        return "Student deleted!!";
    }

    @PutMapping("/updateStud/{studentId}")
    public StudentResponse updateStudent(@PathVariable Long studentId,@RequestBody StudentRequest studentRequest){
        return service.updateStudent(studentId,studentRequest);
    }

    @PostMapping("/{groupId}/assignStud/{studentId}")
    public StudentResponse assignStudent(@PathVariable Long groupId,@PathVariable Long studentId){
        return service.assignStudentToGroup(groupId,studentId);
    }
}
