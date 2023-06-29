package org.adadev.springdemo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.adadev.springdemo.repository.*;
import org.adadev.springdemo.model.*;
import org.adadev.springdemo.dto.*;
import org.adadev.springdemo.error.*;
import org.adadev.springdemo.service.*;

@CrossOrigin
@RestController
public class TaskController {
	@Autowired
	private TaskRepository repository;
		
	@Autowired
	private TaskService taskService;
		
	@GetMapping("/tasks")
	Iterable<BasicTask> index() {

		return this.repository.findProjectedBy(BasicTask.class);
	}

	@PostMapping("/tasks")
	BasicTaskDTO create(@RequestBody Task newTask) {

		return new BasicTaskDTO(repository.save(newTask));
		
	}

	@GetMapping("/tasks/{id}")
	BasicTask one(@PathVariable Long id) {
		return repository.getProjectedById(id, BasicTask.class).orElseThrow(() -> new TaskNotFoundException(id));
	}

	@DeleteMapping("/tasks/{id}")
	ResponseEntity<?> deleteTask(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/tasks/{id}/mark_complete")
	BasicTaskDTO completeTask(@PathVariable Long id) {

		return new BasicTaskDTO(taskService.completeTask(id));
	}
	
	@PatchMapping("/tasks/{id}/mark_incomplete")
	BasicTaskDTO uncompleteTask(@PathVariable Long id) {
		
		return new BasicTaskDTO(taskService.uncompleteTask(id));
	}
}
