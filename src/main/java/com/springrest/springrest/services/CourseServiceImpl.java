package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;

import com.springrest.springrest.entities.Course;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
		
//		list = new ArrayList<>();
//		list.add(new Course(145,"Core Java", "this course contain basics of java"));
//		list.add(new Course(146,"Ada Java", "this course contain advance of java"));
//		
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
		
//		Course c  = null;
//		for(Course course:list ) {
//			if(course.getId()==courseId) {
//				
//				c= course;
//				break;
//			}	
//		}
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				
//			}
//		});
		
		courseDao.save(course);
		
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e-> e.getId()!= parseLong).collect(Collectors.toList());
		
		@SuppressWarnings("deprecation")
		Course entity= courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
	
	
	
	
	
}
