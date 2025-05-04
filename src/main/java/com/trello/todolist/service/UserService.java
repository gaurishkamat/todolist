package com.trello.todolist.service;

import com.trello.todolist.model.User;
import com.trello.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user){
        userRepository.save(user);
    }
}
