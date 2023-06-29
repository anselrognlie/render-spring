package org.adadev.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import org.adadev.springdemo.model.*;

import java.util.*;

public interface TaskRepository extends JpaRepository<Task, Long> {
	<T> List<T> findProjectedBy(Class<T> type);
	<T> Optional<T> getProjectedById(Long id, Class<T> type);
}
