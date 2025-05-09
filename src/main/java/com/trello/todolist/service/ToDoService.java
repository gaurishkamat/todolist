package com.trello.todolist.service;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ListItem addTodo(ListItem listItem){
        toDoRepository.save(listItem);
        return listItem;
    }

    public List<ListItem> getToDos() {
        return toDoRepository.findAll();
    }
}
