package com.sa2.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa2.lms.model.Course;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class producer {
    @Value("${topic.name}")
    private String courceToppic;

    private final ObjectMapper ObjectMapper;

    private final KafkaTemplate<String, String> KafkaTemplate;

    @Autowired
    public producer(KafkaTemplate<String, String> KafkaTemplate, ObjectMapper objectMapper) {

        this.KafkaTemplate = KafkaTemplate;
        this.ObjectMapper = objectMapper;
    }

    public String sendMessage(Course course) throws JsonParseException {
        String courseMessage = ObjectMapper.writeValueAsString(course);
        KafkaTemplate.send(courseTopic, courseMessage);
        log.info("Course produced", courseMessage);
        return "course sent";
    }

}
