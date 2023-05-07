package com.jo.student.Control;

import com.jo.student.Service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CourseControl {


    private final CourseService courseService;

    public CourseControl(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/courses")
    public ModelAndView coursesPage() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courseService.getCourse());
        return mav;
    }


}

