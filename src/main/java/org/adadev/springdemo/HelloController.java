package org.adadev.springdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloController {
	@GetMapping("/greet")
	String greet() {

		return "Hello, Demo";
	}

}
