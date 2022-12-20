package com.example.springrestboothw.converter.responseConverter;
import com.example.springrestboothw.dto.responses.TaskResponse;
import com.example.springrestboothw.entities.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskResponseConverter {

    public TaskResponse convertTaskToResponse(Task task){
        if (task == null) {
            return null;
        }
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setTaskTest(task.getTaskTest());
        taskResponse.setDeadline(task.getDeadline());
        taskResponse.setId(task.getId());
        return taskResponse;
    }

    public List<TaskResponse> viewAllResponse(List<Task> tasks){
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task task:tasks) {
         taskResponses.add(convertTaskToResponse(task));
        }
        return taskResponses;
    }
}
