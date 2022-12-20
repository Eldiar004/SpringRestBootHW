package com.example.springrestboothw.repository;

import com.example.springrestboothw.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
