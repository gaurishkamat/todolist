package com.trello.todolist.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Replace with DB call
        if ("admin".equals(username)) {
            return new User("admin", new BCryptPasswordEncoder().encode("password"),
                    new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}