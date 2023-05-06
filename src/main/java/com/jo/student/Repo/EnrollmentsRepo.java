package com.jo.student.Repo;

import com.jo.student.Model.Enrollments;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentsRepo extends JpaRepository <Enrollments, Long> {
    List<Enrollments> findBySId(Long sId);
}
