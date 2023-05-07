package com.jo.student.Control;

import com.jo.student.Model.Enrollments;
import com.jo.student.Service.EnrollmentsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EnrollmentsControl {

    private final EnrollmentsService enrollmentsService;


    public EnrollmentsControl(EnrollmentsService enrollmentsService) {
        this.enrollmentsService = enrollmentsService;
    }

    @GetMapping("/enrollments")
    public ModelAndView enrollmentsPage(Authentication authentication){
        ModelAndView mav = new ModelAndView("enrollments");
        User userDetails = (User) authentication.getPrincipal();
        long sId = Long.valueOf(userDetails.getUsername());
        mav.addObject("enrollment", enrollmentsService.getEnrollmentsList(sId));
        return mav;
    }

    @GetMapping("/enrol/course/{cId}")
    public String  enrollmentsPage(Authentication authentication, @PathVariable String cId){
        Enrollments enrollment= new Enrollments();
        enrollment.setCourseId(Long.valueOf(cId));
        User userDetails = (User) authentication.getPrincipal();
        long sId = Long.valueOf(userDetails.getUsername());
        enrollment.setStudId(sId);
        enrollmentsService.saveEnrollment(enrollment);
        return "redirect:/enrollments";
    }

}
