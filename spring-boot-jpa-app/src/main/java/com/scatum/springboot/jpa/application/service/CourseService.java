package com.scatum.springboot.jpa.application.service;

import com.scatum.springboot.jpa.application.model.Course;
import com.scatum.springboot.jpa.application.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<Course> getAllCourses(String topicId) {
        return repository.findByTopicId(topicId);
    }

    public Course getCourse(String id) {
        return repository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        repository.save(course);
    }

    public void updateCourse(Course course) {
        repository.save(course);
    }

    public void deleteCourse(String id) {
        repository.deleteById(id);
    }
}
