package com.scatum.springboot.jpa.application.service;

import com.scatum.springboot.jpa.application.model.Topic;
import com.scatum.springboot.jpa.application.repo.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository repository;

//    private static List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framework Description"),
//            new Topic("java", "Core Java", "Core Java Description"),
//            new Topic("javascript", "Javascript", "Javascript Description")
//    ));


    public List<Topic> getAllTopics() {
//        return topics;

        // in case when returning value is Iterable
//        List<Topic> topics = new ArrayList<>();
//        repository.findAll().forEach(topics::add);
        return repository.findAll();
    }

    public Topic getTopic(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return repository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        repository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        repository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(topic -> topic.getId().equals(id));
        repository.deleteById(id);
    }
}
