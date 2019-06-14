package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="todo")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    // not sure how to do the date time -- figured it out, see setDateStarted
    @Column(nullable = false)
    private String description;

    private String datestarted;

    @Column(name="completed")
    private boolean completed;

    // this adds the user id foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties({"todos", "hibernateLazyInitializer"})
    private User user;

    // generated constructor, getters & setters

    public Todo() {
    }

    public Todo(String description, String datestarted, boolean completed, User user) {
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
        this.datestarted = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS").format(new SimpleDateFormat(datestarted));
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