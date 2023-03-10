package com.in28minutes.learnspringboot.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return List.of(new Course(1, "Learn Micro", "in28minutes"),
				new Course(2, "Learn Full Stack", "in28minutes"));
	}
	
	@GetMapping("/courses/2")
	public Course getCourses() {
		return new Course(2, "Learn Full Stack 1", "in28minutes");
	}
}