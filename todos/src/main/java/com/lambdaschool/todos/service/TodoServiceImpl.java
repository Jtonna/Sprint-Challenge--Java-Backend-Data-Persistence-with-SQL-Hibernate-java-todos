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

}
