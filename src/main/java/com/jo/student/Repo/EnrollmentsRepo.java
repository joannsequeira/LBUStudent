package com.jo.student.Repo;

import com.jo.student.Model.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentsRepo extends JpaRepository <Enrollments, Long> {
    public List<Enrollments> findByStudId(Long studId);
}
