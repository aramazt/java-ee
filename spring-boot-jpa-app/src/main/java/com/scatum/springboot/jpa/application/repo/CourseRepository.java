package com.scatum.springboot.jpa.application.repo;

import com.scatum.springboot.jpa.application.model.Course;
import com.scatum.springboot.jpa.application.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


//@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    @Override
    public List<Course> findAll();

    public List<Course> findByTopicId(String topicId);
}
