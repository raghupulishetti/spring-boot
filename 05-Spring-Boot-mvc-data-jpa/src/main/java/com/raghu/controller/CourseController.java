package com.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.model.Course;
import com.raghu.repository.CourseRepository;

//@Controller
@RestController
public class CourseController {

	@Autowired
	CourseRepository courseRepository;

	@RequestMapping("/courses")
	public  List<Course> findAll() {
		return courseRepository.findAll();
	}

	@RequestMapping("/courses/{id}")
	public Course findCourseById(@PathVariable("id") Long id) {
		return courseRepository.findOne(id);
	}
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}

}
