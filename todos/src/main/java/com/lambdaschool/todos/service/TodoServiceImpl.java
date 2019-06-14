package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "todoservice")
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository help;
    @Override
    public List<Todo> findAllById(long id) {
        List<Todo> todolist = new ArrayList<>();
        help.getAllById(id).iterator().forEachRemaining(todolist::add);
        return todolist;
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