package com.trello.todolist.controller;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/greet")
    public String greet()
    {
        return "Welcome to ToDo's!!";
    }

    @GetMapping("/todos")
    public List<ListItem> getList(){
        return toDoService.getToDos();
    }

    @PostMapping("/add")
    public ListItem add(@RequestBody ListItem item){
         return  toDoService.add(item);
    }

    @PutMapping("/update")
    public ListItem update(@RequestBody ListItem item){
        return toDoService.update(item);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        toDoService.delete(id);
    }
}
