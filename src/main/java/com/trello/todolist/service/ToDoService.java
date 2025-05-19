package com.trello.todolist.service;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.model.User;
import com.trello.todolist.repository.ToDoRepository;
import com.trello.todolist.repository.UserRepository;
import com.trello.todolist.utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    private JwtFilter jwtFilter;

    public ListItem add(ListItem listItem){
        toDoRepository.save(listItem);
        return listItem;
    }

    public ListItem update(ListItem listItem) throws AccessDeniedException {
        String username = jwtFilter.getLoggedInUsername();
        ListItem existingItem = toDoRepository.findById(listItem.getId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (!existingItem.getUser().getUsername().equals(username)) {
            throw new AccessDeniedException("You are not allowed to update this todo.");
        }

        existingItem.setTitle(listItem.getTitle());
        existingItem.setDescription(listItem.getDescription());

        return toDoRepository.save(existingItem);
    }

    public List<ListItem> getToDos() {
        String username = jwtFilter.getLoggedInUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        return toDoRepository.findByUser(user);

    }

    public void delete(Integer id) throws AccessDeniedException{
        String username = jwtFilter.getLoggedInUsername();

        ListItem existingItem = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (!existingItem.getUser().getUsername().equals(username)) {
            throw new AccessDeniedException("You are not allowed to update this todo.");
        }

        toDoRepository.deleteById(id);
    }
}
