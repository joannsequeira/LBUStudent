package com.jo.student.Repo;

import com.jo.student.Model.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentsRepo extends JpaRepository <Enrollments, Long> {
    List<Enrollments> findBySId(Long sId);
}
