package com.jo.student.Service;

import com.jo.student.Model.Student;
import com.jo.student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Student getEmail(String email){
        Student stud = studentRepo.findByEmail(email);
        return stud;
    }

    @Override
    public Student newUser(Student student){
        Random ran = new Random();
        Integer numb = ran.nextInt(30000) + 10000;
        student.setId(Long.valueOf((Integer)numb));
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
    }

    public void updateStudent(Student student){
        Student studentSys = studentRepo.findById(student.getId());
        studentSys.setF_Name(student.getF_Name());
        studentSys.setL_Name(studentSys.getL_Name());
        studentSys.getPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(studentSys);
    }
    public Student getById(Long Id){
        Student student = studentRepo.findById(Id);
        return student;
    }
}
