package com.jo.student.Control;

import com.jo.student.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseControl {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ModelAndView coursesPage() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courseService.getCourse());
        return mav;
    }

}

