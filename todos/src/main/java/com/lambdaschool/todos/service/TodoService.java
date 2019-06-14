package com.lambdaschool.todos.service;


import com.lambdaschool.todos.model.Todo;

import java.util.ArrayList;

public interface TodoService
{
    ArrayList<Todo> findAll();

    Todo findTodoById(long id);

    Todo findTodoByName(String name);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);

    void deleteTodo(long todosid);

    void saveTodo(long todosid);
}
