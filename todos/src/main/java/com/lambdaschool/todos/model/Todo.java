package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    // not sure how to do the date time -- figured it out, see setDateStarted
    @Column(nullable = false)
    private String description;

    private String datestarted;

    private boolean completed;

    // this adds the user id foreign key
    @ManyToOne
    @JoinColumn(name = "todos")
    @JsonIgnoreProperties({"todos"})
    private User user;

    // generated constructor, getters & setters

    public Todo() {
    }

    public Todo(String description, String datestarted, boolean completed) {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
    }

    public Todo(String description, String datestarted, User user){
        this.description = description;
        this.datestarted = datestarted;
        this.user = user;
        this.completed = false;
    }

    public Todo(String description, String datestarted, boolean completed, User user){
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
        this.user = user;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = datestarted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}