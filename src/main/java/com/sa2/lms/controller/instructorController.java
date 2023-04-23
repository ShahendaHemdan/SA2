package com.sa2.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sa2.lms.model.Course;
import com.sa2.lms.service.instructorService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class instructorController {
    private final instructorService instructorService;

    @Autowired
    public instructorController(instructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("publishCourse")
    public String publishCourse(@RequestBody Course course) throws JsonProcessingException {
        log.info("publish course request recevied");
        return instructorService.sendCourse(course);
    }

    @DeleteMapping("deleteCourse")
    public String deleteCourse(@RequestBody Course course) throws JsonProcessingException {
        log.info("delete course request recevied");
        course.setDelete(true);
        return instructorService.deleteCourse(course);
    }
}
