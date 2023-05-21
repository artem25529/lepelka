package com.es.lepelka.service;

import com.es.lepelka.model.Topic;
import com.es.lepelka.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
