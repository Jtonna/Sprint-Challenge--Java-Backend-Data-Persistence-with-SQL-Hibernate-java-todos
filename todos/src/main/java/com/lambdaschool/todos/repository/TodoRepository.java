package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.model.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    // gets all the T0do's from the list by the id
    @Query(value = "SELECT * FROM todo WHERE todos = :userid", nativeQuery = true)
    List<Todo> getAllById(long userid);
    // verified this is working

    // deletes by id
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM todo WHERE userid = :userid", nativeQuery = true)
    void deleteAllByUserId(long userid);
}
