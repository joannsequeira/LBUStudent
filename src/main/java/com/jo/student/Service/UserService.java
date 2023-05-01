package com.jo.student.Service;

import com.jo.student.Model.Student;
import com.jo.student.Repo.StudentRepo;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public User loadUserByUsername(String email) {
        Student user = studentRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new User(
                String.valueOf(user.getId()),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("STUDENT"))

        );
    }
}
