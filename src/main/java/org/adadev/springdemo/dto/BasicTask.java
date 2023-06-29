package org.adadev.springdemo.dto;

import org.springframework.beans.factory.annotation.*;
import com.fasterxml.jackson.annotation.*;

public interface BasicTask {
	public long getId();
	public String getTitle();
	public String getDescription();
	
	// Spring Expression Language (SpEL)
	@Value("#{target.isComplete()}")
	@JsonProperty("isComplete")
	public boolean isComplete();
}
