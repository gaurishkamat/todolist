package com.trello.todolist.controller;

import com.trello.todolist.model.ListItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    @GetMapping("/greet")
    public String greet()
    {
        return "Welcome to ToDo's!!";
    }

    @GetMapping("/todos")
    public List<ListItem> getList(){
        return Arrays.asList(new ListItem(1, "Practice Java", "Write todo controller in Java", "10/12/2024", "pending"),
                new ListItem(1, "Practice React", "Write todo FE component", "10/12/2024", "pending"));
    }
}
