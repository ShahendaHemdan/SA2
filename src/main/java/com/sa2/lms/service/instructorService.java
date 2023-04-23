package com.sa2.lms.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.sa2.lms.service.producer;
import org.springframework.beans.factory.annotation.Autowired;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sa2.lms.domain.courseDto;
import com.sa2.lms.model.Course;
import com.sa2.lms.repository.courseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class instructorService {
    @Autowired

    public instructorService(producer producer) {
        this.producer = producer;
    }

    public String sendCourse(Course course) throws JsonParseException {
        return producer.sendMessage(course);
    }

    public String deleteCourse(Course course) throws JsonParseException {
        return producer.sendMessage(course);
    }
}
