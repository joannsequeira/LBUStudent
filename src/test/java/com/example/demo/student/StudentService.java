package com.example.demo.student;
import com.example.demo.student.Repository.StudentRepository;
import com.example.demo.student.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return studentRepository.findByEmail(email);
    }

    private final StudentService studentService;
    private final EmailValid emailValid;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValid.test(request.getEmail());
    if (!isValidEmail) {
        System.out.println("Not a valid email");
    }
        return studentService.signUpStud(
                new Student(
                     request.getF_Name(),
                     request.getL_Name(),
                     request.getEmail(),
                     request.getPassword()
                )
        );
    }

    private String signUpStud (Student student)
    {
       boolean studExists = studentRepository.findByEmail(student.getEmail())
                .isPresent();
       if (studExists) {
           throw new IllegalStateException("Email in Use");
       }
       return "";
    }
}