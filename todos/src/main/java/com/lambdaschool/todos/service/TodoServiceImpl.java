package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return help.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Todo save(Todo todo) {
        return help.save(todo);
    }

    @Override
    public void delete(long id) {
        if (help.findById(id).isPresent()){
            help.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }

    }

    @Override
    public Todo update(Todo todo, long id) {
        Todo currentTodo = help.findById(id).orElseThrow(EntityNotFoundException::new);

        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }

        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }

        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        } else {
            currentTodo.setCompleted(false);
        }

        help.save(currentTodo);
        return currentTodo;
    }
}