package com.jo.student.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudControl {
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

}
