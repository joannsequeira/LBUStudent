package com.jo.student.Repo;

import com.jo.student.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    public List<Course> findBycName(String name);

}
