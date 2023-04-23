package com.sa2.lms.repository;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sa2.lms.model.Course;

@Repository
public interface courseRepository extends JpaRepository<Course, Long> {

}
