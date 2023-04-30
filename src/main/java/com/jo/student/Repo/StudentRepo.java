package com.jo.student.Repo;

import com.jo.student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository <Student, Integer> {
    public Student getStudById(Integer Id);
    public Student findByEmail(String email);
}
