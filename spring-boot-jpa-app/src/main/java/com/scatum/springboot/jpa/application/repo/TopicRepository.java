package com.scatum.springboot.jpa.application.repo;

import com.scatum.springboot.jpa.application.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {

    @Override
    List<Topic> findAll();
}
