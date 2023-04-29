package com.jo.student.Service;

import com.jo.student.Model.Student;
import com.jo.student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServ {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student newUser(Student student) {
        return studentRepo.save(student);
    }
}
