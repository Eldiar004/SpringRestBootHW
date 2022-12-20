package com.example.springrestboothw.converter.requestConverter;
import com.example.springrestboothw.dto.requests.TaskRequest;
import com.example.springrestboothw.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestConverter {

    public Task convertRequestToTask(TaskRequest taskRequest){
        if (taskRequest == null){
            return null;
        }
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskTest(taskRequest.getTaskTest());
        task.setDeadline(taskRequest.getDeadline());
        return task;
    }

    public void updateTask(Task task,TaskRequest taskRequest){
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskTest(taskRequest.getTaskTest());
        task.setDeadline(taskRequest.getDeadline());
    }
}
