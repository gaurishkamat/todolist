package com.trello.todolist.repository;

import com.trello.todolist.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ListItem, Integer> {
}
