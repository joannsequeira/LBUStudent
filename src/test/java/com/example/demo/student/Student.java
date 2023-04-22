package com.example.demo.student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {
    private Long Id;
    private String f_name;
    private String l_name;
    private String email;
    private String password;

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    public Student(String f_name,
                   String l_name,
                   String email,
                   String password) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.password = password;
    }
}




