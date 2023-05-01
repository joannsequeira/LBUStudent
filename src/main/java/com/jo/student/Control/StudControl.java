package com.jo.student.Control;

import com.jo.student.Model.Student;
import com.jo.student.Service.CourseService;
import com.jo.student.Service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudControl {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;


    @GetMapping("/login")
    public String login(org.springframework.ui.Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

    @Resource(name = "authenticationManager")
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute Student student, HttpServletRequest request) {
        String email = student.getEmail();
        String password = student.getPassword();

        Student loggedStud = studentService.getEmail(email);
        if (loggedStud != null) {
            if (email.equals(loggedStud.getEmail()) && password.equals(loggedStud.getPassword())) {
                try {
                    UsernamePasswordAuthenticationToken authReq =
                            new UsernamePasswordAuthenticationToken(email, password);
                    Authentication authentication = authManager.authenticate(authReq);
                    SecurityContext sc = SecurityContextHolder.getContext();
                    sc.setAuthentication(authentication);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
                } catch (Exception e) {
                    SecurityContextHolder.getContext().setAuthentication(null);
                }

                return "redirect:/courses";
            }
            System.out.println("=> No record exist.");
        }

        return "redirect:/login?error=true";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }


    @PostMapping("/register")
    public String reg(@ModelAttribute Student student, HttpSession session) {
        studentService.newUser(student);

        /*boolean f = studentService.checkEmail(student.getEmail());
        if (f) {
            session.setAttribute("msg", "Email in Use");
        } else {
            student = studentService.newUser(student);
            if (student != null) {
                session.setAttribute("msg", "Registration Successful");
            } else {
                session.setAttribute("msg", "Not Successful, Try Again!");
            }

        } */
        return "redirect:/login";
    }

    @GetMapping("/courses")
    public ModelAndView coursesPage() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courseService.getCourse());
        return mav;
    }
}