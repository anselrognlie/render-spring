package org.adadev.springdemo.error;

public class TaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 553633920910090016L;
	private long id;
	
	public TaskNotFoundException(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
}
