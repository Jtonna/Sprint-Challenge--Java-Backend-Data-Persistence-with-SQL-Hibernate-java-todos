package com.lambdaschool.todos.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name="todo")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(name="description", nullable = false, unique = true )
    private String description;

    @Column(name = "datestarted")
    protected Date datestarted;

    @Column(name="completed")
    private boolean completed;


}