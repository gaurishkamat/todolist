package com.trello.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ToDoController {

    @GetMapping("/greet")
    public String greet()
    {
        return "Welcome to ToDo's!!";
    }
}
