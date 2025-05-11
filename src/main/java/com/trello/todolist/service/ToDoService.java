package com.trello.todolist.service;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ListItem add(ListItem listItem){
        toDoRepository.save(listItem);
        return listItem;
    }

    public ListItem update(ListItem listItem){
        Optional<ListItem> optionalItem = toDoRepository.findById(listItem.getId());
        if (optionalItem.isPresent()) {
            ListItem existingItem = optionalItem.get();
            existingItem.setTitle(listItem.getTitle());
            existingItem.setDescription(listItem.getDescription());
            existingItem.setStatus(listItem.getStatus());

            return toDoRepository.save(existingItem);
        } else {
            throw new RuntimeException("ToDo item not found with id: " + listItem.getId());
        }
    }

    public List<ListItem> getToDos() {
        return toDoRepository.findAll();
    }
}
