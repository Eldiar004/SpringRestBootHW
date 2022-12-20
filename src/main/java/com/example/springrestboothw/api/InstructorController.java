package com.example.springrestboothw.api;
import com.example.springrestboothw.dto.requests.InstructorRequest;
import com.example.springrestboothw.dto.responses.InstructorResponse;
import com.example.springrestboothw.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ins")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/saveIns/{courseId}")
    public InstructorResponse saveInstructor(@PathVariable Long courseId, @RequestBody InstructorRequest instructorRequest){
        return instructorService.saveInstructorByCourseId(courseId,instructorRequest);
    }

    @GetMapping("/instructors")
    public List<InstructorResponse> getInstructors(){
        return instructorService.getAllInstructor();
    }

    @PutMapping("/updateIns/{instructorId}")
    public InstructorResponse updateInstructor(@PathVariable Long instructorId,@RequestBody InstructorRequest instructorRequest){
        return instructorService.updateInstructor(instructorId,instructorRequest);
    }

    @DeleteMapping("/deleteIns/{instructorId}")
    public String deleteInstructor(@PathVariable Long instructorId){
        instructorService.deleteInstructorById(instructorId);
        return "Deleted!!";
    }

    @PostMapping("/{courseId}/assignIns/{instructorId}")
    public InstructorResponse assignInstructorToCourse(@PathVariable Long courseId,@PathVariable Long instructorId){
        return instructorService.assignInstructorToCourseById(courseId,instructorId);
    }
}
