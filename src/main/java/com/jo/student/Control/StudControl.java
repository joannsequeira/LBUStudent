package com.jo.student.Control;

import ch.qos.logback.core.model.Model;
import com.jo.student.Model.Student;
import com.jo.student.Service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudControl {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String login()
    {
        //model.setAttribute("student", new Student());
        return "login";
    }


    @GetMapping("/register")
    public String register()
    {
        return "register";
    }


    @PostMapping("/newUser")
    public String newUser(@ModelAttribute Student student, HttpSession session){
        boolean f = studentService.checkEmail(student.getEmail());
        if(f)
        {
            session.setAttribute("msg","Email in Use");
        } else {
            student = studentService.newUser(student);
            if (student != null) {
                session.setAttribute("msg", "Registration Successful");
            } else {
                session.setAttribute("msg", "Not Successful, Try Again!");
            }
        }
        return "redirect:/register";
    }

}
