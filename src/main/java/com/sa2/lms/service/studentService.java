package com.sa2.lms.service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa2.lms.domain.courseDto;
import com.sa2.lms.model.Course;
import com.sa2.lms.repository.courseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.java.Log;

@Service
public class studentService {
    private static final Logger logger = LoggerFactory.getLogger(studentService.class);

    @Autowired
    private courseRepository courseRepository;

    public List<Course> findAll() {
        List<Course> courses = courseRepository.findAll();
        logger.info("course size {}", courses);
        return courses;
    }

    public Course findById(long id) {
        Optional<Course> course = courseRepository.findById(id);
        logger.info("offer featched {}", course);
        return course.orElse(null);
    }

    public String deleteCourse(Course course) {
        courseRepository.deleteById(course.getId());
        logger.info("Course Deleted", course.getId());
        return "course with id" + course.getId() + " deleted";
    }

    // public Course save(Course course) {
    // return courseRepository.save(course);
    // }

    public void persisteCourse(courseDto courseDto) {
        ModelMapper modelMapper = new ModelMapper();
        Course course = modelMapper.map(courseDto, Course.class);
        Course persisteCourse = courseRepository.save(course);
        logger.info("Course persisted {}", persisteCourse);

    }

    // public Course updateCourse(Course updatedCourse, long id) {
    // Optional<Course> oldCourse = courseRepository.findById(id);
    // if (oldCourse.isPresent()) {
    // Course course = oldCourse.get();
    // course.setId(updatedCourse.getId());
    // course.setName(updatedCourse.getName());
    // course.setCode(updatedCourse.getCode());
    // return courseRepository.save(course);

    // } else {
    // return null;
    // }

    // }
}
