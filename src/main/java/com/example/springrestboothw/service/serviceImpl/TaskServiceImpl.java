package com.example.springrestboothw.service.serviceImpl;
import com.example.springrestboothw.converter.requestConverter.TaskRequestConverter;
import com.example.springrestboothw.converter.responseConverter.TaskResponseConverter;
import com.example.springrestboothw.dto.requests.TaskRequest;
import com.example.springrestboothw.dto.responses.TaskResponse;
import com.example.springrestboothw.entities.Lesson;
import com.example.springrestboothw.entities.Task;
import com.example.springrestboothw.repository.LessonRepository;
import com.example.springrestboothw.repository.TaskRepository;
import com.example.springrestboothw.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskRequestConverter taskRequestConverter;
    private final TaskResponseConverter taskResponseConverter;
    private final LessonRepository lessonRepository;

    @Override
    public TaskResponse getById(Long id) {
        return taskResponseConverter.convertTaskToResponse(repository.findById(id).get());
    }

    public TaskResponse saveTaskByLessonId(Long lessonId, TaskRequest taskRequest){
        Lesson lesson = lessonRepository.findById(lessonId).get();
        Task task = taskRequestConverter.convertRequestToTask(taskRequest);
        task.setLesson(lesson);
        repository.save(task);
        return taskResponseConverter.convertTaskToResponse(task);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getAllTask() {
        return taskResponseConverter.viewAllResponse(repository.findAll());
    }

    public TaskResponse updateTask(Long id,TaskRequest taskRequest){
        Task task = repository.findById(id).get();
        taskRequestConverter.updateTask(task,taskRequest);
        return taskResponseConverter.convertTaskToResponse(repository.save(task));
    }
}