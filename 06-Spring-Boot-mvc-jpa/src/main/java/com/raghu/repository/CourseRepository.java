package com.raghu.repository;

import java.util.List;

import com.raghu.model.Course;

public interface CourseRepository  {

	List<Course> findAll();

	Course findOne(Long id);

	Course save(Course course);

}
