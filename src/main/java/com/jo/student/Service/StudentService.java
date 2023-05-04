package com.jo.student.Service;

import com.jo.student.Model.Student;
import com.jo.student.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
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
        student.setsId((long)numb);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
        return null;
    }

    public void updateStudent(Student student) {
        Student stud = studentRepo.findBySId(student.getsId());
            stud.setF_Name(student.getF_Name());
            stud.setF_Name(student.getL_Name());
            stud.setPassword(passwordEncoder.encode(student.getPassword()));
            studentRepo.save(stud);
        }


    public Student getStudentBySId(Long sId) {
        Student student = studentRepo.findBySId(sId);
        return student;
    }

    public Boolean getGrad(long sId) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8081/accounts/student/"+sId;
        ResponseEntity<Map> response = restTemplate.getForEntity(fooResourceUrl, Map.class);
        Map map = response.getBody();
        boolean hasOutstandingBalance = (boolean) map.get("hasOutstandingBalance");
        return !hasOutstandingBalance;
    }
}
