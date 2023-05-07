package com.jo.student.Service;

import com.jo.student.Model.Enrollments;
import com.jo.student.Repo.EnrollmentsRepo;
import com.jo.student.Repo.StudentRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrollmentsService {


    private final EnrollmentsRepo enrollmentsRepo;

    private final StudentRepo studentRepo;

    public EnrollmentsService(EnrollmentsRepo enrollmentsRepo, StudentRepo studentRepo) {
        this.enrollmentsRepo = enrollmentsRepo;
        this.studentRepo = studentRepo;
    }

    public List<Enrollments> getEnrollmentsList(Long studId){
        return enrollmentsRepo.findByStudId(studId);
    }

    public void saveEnrollment(Enrollments enrollments) {
        enrollmentsRepo.save(enrollments);
    }



}
