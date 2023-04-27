package com.example.demo.student;
import lombok.*;

@Getter
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private final String f_name;
    private final String l_name;
    private final String email;
    private final String password;

}
