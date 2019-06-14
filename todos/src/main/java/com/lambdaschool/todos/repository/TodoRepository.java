package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    // gets all by id
    @Query(value = "select * from todo where todos = :userid", nativeQuery = true )
    List<Todo> getAllById(long userid);
}
