package com.jo.student.Service;

import com.jo.student.Model.Course;
import com.jo.student.Repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseService  {

    @Autowired
    CourseRepo courseRepo;

    public List<Course>getCourse(){
        List<Course> courseList = courseRepo.findAll();
        return courseList;
    }

    public List<Course> searchCourse(String name) {
        List<Course> courseList = courseRepo.findBycName(name);
        return courseList;
    }


}
