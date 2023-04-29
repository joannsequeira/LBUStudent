package com.jo.student.Control;

import com.jo.student.Model.Student;
import com.jo.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudControl {

    @Autowired
    private StudentService studentService;
    @GetMapping("/Login")
    public String Login()
    {
        return "Login";
    }
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }


    @PostMapping("/newUser")
    public String newUser(@ModelAttribute Student student){

        return "redirect:/registration";
    }

}
