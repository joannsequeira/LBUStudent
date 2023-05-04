package com.jo.student.Service;

import com.jo.student.Model.Enrollments;
import com.jo.student.Repo.EnrollmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnrollmentsService {

    @Autowired
    EnrollmentsRepo enrollmentsRepo;

    public List<Enrollments> getEnrollmentsList(Long Id) {
    List<Enrollments> enrollmentsList = enrollmentsRepo.findById(Id);
    return enrollmentsList; }

    public void saveEnrollment(Enrollments enrollments) {
        enrollmentsRepo.save(enrollments);
    }



}
