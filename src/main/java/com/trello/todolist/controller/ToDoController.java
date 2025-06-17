package com.trello.todolist.controller;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.model.User;
import com.trello.todolist.repository.UserRepository;
import com.trello.todolist.service.ToDoService;
import com.trello.todolist.utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.Arrays;
import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtFilter jwtFilter;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/todos")
    public List<ListItem> getList(){
        return toDoService.getToDos();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public ListItem add(@RequestBody ListItem item){
        String username = JwtFilter.getLoggedInUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        item.setUser(user);
         return  toDoService.add(item);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update")
    public ListItem update(@RequestBody ListItem item) throws AccessDeniedException {
        return toDoService.update(item);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws AccessDeniedException {
        toDoService.delete(id);
    }
}
