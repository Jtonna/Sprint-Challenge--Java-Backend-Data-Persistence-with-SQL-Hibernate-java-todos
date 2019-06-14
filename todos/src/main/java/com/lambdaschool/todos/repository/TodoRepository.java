package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Query(value = "SELECT * FROM todos",nativeQuery = true)
    ArrayList<getTodoList> getTodos();
}