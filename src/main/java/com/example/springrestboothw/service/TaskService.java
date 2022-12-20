package com.example.springrestboothw.service;

import com.example.springrestboothw.converter.responseConverter.TaskResponseConverter;
import com.example.springrestboothw.dto.requests.TaskRequest;
import com.example.springrestboothw.dto.responses.TaskResponse;
import com.example.springrestboothw.entities.Task;

import java.util.List;

public interface TaskService {
    TaskResponse getById(Long id);
    TaskResponse saveTaskByLessonId(Long lessonId, TaskRequest taskRequest);
    void deleteById(Long id);
    List<TaskResponse> getAllTask();
    TaskResponse updateTask(Long id,TaskRequest taskRequest);
}
