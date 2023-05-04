package com.jo.student.Repo;

import com.jo.student.Model.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentsRepo extends JpaRepository <Enrollments, Long> {
    Optional<Enrollments> findById(Long Id);
}
