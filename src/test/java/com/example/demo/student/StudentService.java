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

    @Override
    public Student loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return StudentRepository.findByEmail(email);
    }

    public String register(RegistrationRequest request) {
     return null;
    }
}