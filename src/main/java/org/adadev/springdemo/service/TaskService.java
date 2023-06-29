package org.adadev.springdemo.service;

import java.time.LocalDateTime;

import org.adadev.springdemo.repository.*;
import org.adadev.springdemo.model.*;
import org.adadev.springdemo.error.*;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task completeTask(Long id) {
		return taskRepository.findById(id)
				.map(task -> {
					LocalDateTime now = LocalDateTime.now();
					task.setCompletedAt(now);
					return taskRepository.save(task);
				}) //
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
	
	public Task uncompleteTask(Long id) {
		return taskRepository.findById(id)
				.map(task -> {
					task.setCompletedAt(null);
					return taskRepository.save(task);
				}) //
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
}
