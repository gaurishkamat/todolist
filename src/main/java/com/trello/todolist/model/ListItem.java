package com.trello.todolist.model;

import jakarta.persistence.*;

@Entity
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String title;
    private String description;
    private String dateCreated;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user-id")
    private User user;

    public ListItem() {
    }

    public ListItem(int id, String title, String description, String dateCreated, String status) {
        Id = id;
        this.title = title;
        this.description = description;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
