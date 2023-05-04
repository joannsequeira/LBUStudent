package com.jo.student.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollments {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enrollId;
    @Column(nullable = false)
    private Long Id;
    @Column(nullable = false)
    private Long cId;
}

