package com.example.demo.student;

import com.example.demo.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
    public class UserController {

        @Autowired
        StudentService studentService;


        @GetMapping("/login")
        public String login(Model model) {
            model.addAttribute("student", new Student());
            return "login";
        }

        @PostMapping("/login")
        public String authenticate(@ModelAttribute Student student) {
            String email = student.getEmail();
            String password = student.getPassword();
            // authenticate user
            Student studLogin = studentService.getEmail(email);
            if(studLogin != null) {
                if (email.equals(studLogin.getEmail()) && password.equals(studLogin.getPassword())) {
                    return "redirect:/enrollments";
                }
                System.out.println("No record Found");
            }
            return "redirect:/login?error=true";
        }


        @GetMapping("/register")
        public String register(@RequestBody RegistrationRequest request) {
            return studentService.register(request);
             // return registration form
        }

        @PostMapping("/register")
        public String register(@ModelAttribute Student student) {
            // create new student
        }
    }

}
