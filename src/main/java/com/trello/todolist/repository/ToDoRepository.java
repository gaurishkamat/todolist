package com.trello.todolist.repository;

import com.trello.todolist.model.ListItem;
import com.trello.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ListItem, Integer> {
    List<ListItem> findByUser(User user);
}
