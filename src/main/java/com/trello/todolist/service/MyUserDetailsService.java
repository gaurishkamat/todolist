package com.trello.todolist.service;

import com.trello.todolist.model.Role;
import com.trello.todolist.model.User;
import com.trello.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Replace with DB call
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Role role = user.getRole();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role.getName()));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // should be already encoded
                Collections.emptyList() // authorities/roles can be added here
        );
    }
}