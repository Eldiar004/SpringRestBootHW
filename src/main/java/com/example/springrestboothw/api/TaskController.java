package com.example.springrestboothw.api;
import com.example.springrestboothw.dto.requests.TaskRequest;
import com.example.springrestboothw.dto.responses.TaskResponse;
import com.example.springrestboothw.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;


    @GetMapping("/tasks")
    public List<TaskResponse> getAllTask(){
        return taskService.getAllTask();
    }

    @PostMapping("/saveTask")
    public TaskResponse saveTask(@PathVariable Long lessonId,@RequestBody TaskRequest taskRequest){
        return taskService.saveTaskByLessonId(lessonId,taskRequest);
    }

    @DeleteMapping
    public String deleteTask(@PathVariable Long taskId){
        taskService.deleteById(taskId);
        return "Task deleted!!";
    }

    @PutMapping("/updateTask")
    public TaskResponse updateTask(@PathVariable Long taskId,@RequestBody TaskRequest taskRequest){
        return taskService.updateTask(taskId,taskRequest);
    }
}
