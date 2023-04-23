package com.sa2.lms.controller;

import java.util.List;
import com.sa2.lms.model.Course;
import com.sa2.lms.service.studentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("/course")
public class studentController {
    @Autowired
    private studentService studentService;

    @GetMapping("/all")
    public List<Course> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    //////////////////////////
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        studentService.deleteById(id);
        return " Course with id: " + id + " deleted from the database";
    }

    @PostMapping
    public String save(@RequestBody Course course) {
        return studentService.save(course) + "saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Course course, @PathVariable Long id) {
        return studentService.updateCourse(course, id) + "updated successfully";
    }

}
