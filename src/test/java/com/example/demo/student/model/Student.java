package com.example.demo.student.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {


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
    private Long Id;
    private String f_Name;
    private String l_Name;
    private String email;
    private String password;
    @jakarta.persistence.Id
    private Long id;

    public Student(String fName,
                   String lName,
                   String email,
                   String password
    ) { }

    public Long getId() {
        return Id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public boolean isPresent() {
        return false;
    }
}




