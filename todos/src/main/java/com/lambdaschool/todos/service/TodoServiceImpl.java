package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "todoservice")
public class TodoServiceImpl implements TodoService {

    @Override
    public List<Todo> findAllById(long id) {
        return null;
    }

    @Override
    public Todo findTodoById(long id) {
        return null;
    }

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Todo update(Todo todo, long id) {
        return null;
    }
}