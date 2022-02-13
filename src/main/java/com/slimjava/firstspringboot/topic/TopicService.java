package com.slimjava.firstspringboot.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;


    public List<Topic> getAllTopics () {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        System.out.println(topicRepository.findAll());
        System.out.println("get all");

        return topics;
    }

    public Optional<Topic> getTopic (String id) {
        return topicRepository.findById(id);
    }

    public void addTopic (Topic newTopic) {
        System.out.println("add topic");
        System.out.println(newTopic);

        topicRepository.save(newTopic);
    }

    public void updateTopic (Topic newTopic, String id) {
        topicRepository.save(newTopic);

    }

    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }

}
