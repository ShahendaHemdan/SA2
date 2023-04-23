package com.sa2.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa2.lms.domain.courseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class consumer {
    private static final String offerTopic = "${topic.name}";
    private final ObjectMapper ObjectMapper;
    private final studentService studentService;

    @Autowired
    public consumer(ObjectMapper ObjectMapper, studentService studentService) {
        this.ObjectMapper = ObjectMapper;
        this.studentService = studentService;
    }

    @KafkaListener(topics = courseTopic)
    public void consuneMessage(String message) throws JsonProcessingException {

        log.info("message consumed", message);
        courseDto courseDto = ObjectMapper.readValue(message, courseDto.class);
        if (courseDto.delete){
            studentService.deleteCourse(course)
        }else{
            studentService.persisteCourse(courseDto);
        }
    }

}
