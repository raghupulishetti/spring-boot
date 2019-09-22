package com.raghu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.raghu.model.Course;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Course> findAll() {
		Query query = entityManager.createQuery("select c from Course c", Course.class);
		return query.getResultList();
	}

	@Override
	public Course findOne(Long id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public Course save(Course course) {
		entityManager.persist(course);
		return course;
	}

}
