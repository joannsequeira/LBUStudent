package com.example.demo.student;
import lombok.*;

@Getter
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private final String f_Name;
    private final String l_Name;
    private final String email;
    private final String password;

}
