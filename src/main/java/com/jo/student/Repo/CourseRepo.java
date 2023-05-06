package com.jo.student.Repo;

import com.jo.student.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    public List<Course> findBycName(String name);

}
