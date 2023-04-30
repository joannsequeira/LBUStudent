package com.jo.student.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(nullable = false, unique = true)
    private Integer cId;
    @Column(nullable = false)
    private String cName;
    @Column(nullable = false)
    private Float fee;
    @Column(nullable = false)
    private Integer points;
}

