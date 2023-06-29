package org.adadev.springdemo.dto;

import org.adadev.springdemo.model.Task;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasicTaskDTO {
	private final Task task;
	
	public BasicTaskDTO(Task t) {
		this.task = t;
	}
	
	public long getId() {
		return this.task.getId();
	}
	
	public String getTitle() {
		return this.task.getTitle();
	}
	
	public String getDescription() {
		return this.task.getDescription();
	}
	
	@JsonProperty("isComplete")
	public boolean isComplete() {
		return this.task.isComplete();
	}

}
