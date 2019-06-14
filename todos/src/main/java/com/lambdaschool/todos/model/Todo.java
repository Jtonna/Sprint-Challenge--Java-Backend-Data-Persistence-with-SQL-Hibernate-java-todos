package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    // not sure how to do the date time
    @Column(nullable = false)
    private String description, datestarted;

    @Column(name="completed")
    private boolean completed;

    // this adds the user id foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties({"todos", "hibernateLazyInitializer"})
    private User user;

    // generated constructor, getters & setters

    

}