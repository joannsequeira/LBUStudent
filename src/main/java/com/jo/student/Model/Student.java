package com.jo.student.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    @Column(nullable = false, unique = true)
    private Long sId;
    @Column (nullable = false)
    private String f_Name;
    @Column (nullable = false)
    private String l_Name;
    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = false, unique = true)
    private String password;


   public Long getId() {
        return Id;
    }

    public void setId(Long id) {

       Id = id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
                                  this.l_Name = l_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(String password) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getSId() {
       return sId;
    }

    public void setSId(long sId) {
       this.sId = sId;
    }
}
