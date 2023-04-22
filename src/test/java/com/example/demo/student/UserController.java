package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    @Controller
    public class UserController {

        @Autowired
        private StudentService studentService;

        @GetMapping("/login")
        public String login() {
            // return login form
        }

        @PostMapping("/login")
        public String authenticate(@RequestParam String email, @RequestParam String password) {
            // authenticate user
        }

        @GetMapping("/register")
        public String register() {
            // return registration form
        }

        @PostMapping("/register")
        public String register(@ModelAttribute Student student) {
            // create new student
        }
    }

}
