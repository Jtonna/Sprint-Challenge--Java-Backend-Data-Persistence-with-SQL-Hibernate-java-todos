package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TodoServiceImpl implements TodoService{

    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Override
    public ArrayList<Todo> findAll() {
        ArrayList<Todo> list = new ArrayList<>();
        Todo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Todo findTodoById(long id) {
        return null;
    }

    @Override
    public Todo findTodoByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Todo save(Todo todo) {
        return null;
    }

    @Override
    public Todo update(Todo todo, long id) {
        return null;
    }

    @Override
    public void deleteTodo(long todosid) {

    }

    @Override
    public void saveTodo(long todosid) {

    }
}
