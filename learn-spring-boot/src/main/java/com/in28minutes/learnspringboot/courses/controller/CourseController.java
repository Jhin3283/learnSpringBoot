package com.in28minutes.learnspringboot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;
import com.in28minutes.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository repository;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
//		return List.of(new Course(1, "Learn Micro", "in28minutes"), new Course(2, "Learn Full Stack", "in28minutes"));
	}

	@GetMapping("/courses/{id}")
	public Course getCourses(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with id " + id);
		} return course.get();
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@RequestBody Course course) {
		repository.save(course);
	}
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}
}