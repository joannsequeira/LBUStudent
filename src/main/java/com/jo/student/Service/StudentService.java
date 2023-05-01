package com.jo.student.Service;

import com.jo.student.Model.Student;
import com.jo.student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Component
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Student getEmail(String email){
        Student stud = studentRepo.findByEmail(email);
        return stud;
    }

    public Student newUser(Student student){
        Random ran = new Random();
        Integer numb = ran.nextInt(30000) + 10000;
        student.setId(Long.valueOf((Integer)numb));
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
        return null;
    }

    public void updateStudent(Student student) {
        Optional<Student> optionalStudent = studentRepo.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student studentSys = optionalStudent.get();
            studentSys.setF_Name(student.getF_Name());
            studentSys.setF_Name(student.getL_Name());
            studentSys.setPassword(passwordEncoder.encode(student.getPassword()));
            studentRepo.save(studentSys);
        } else {
            throw new IllegalArgumentException("Invalid student ID");
        }
    }


    public Optional<Student> getById(Long Id){
        Optional<Student> student = studentRepo.findById(Id);
        return student;
    }
}
