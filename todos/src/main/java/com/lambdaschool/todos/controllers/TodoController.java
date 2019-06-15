package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.model.User;
import com.lambdaschool.todos.service.TodoService;
import com.lambdaschool.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class TodoController {
    @Autowired
    private TodoService todosService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/mine", produces = {"application/json"})
    public ResponseEntity<?> getMyTodos(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByUsername(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername());
        return new ResponseEntity<>(todosService.findAllById(currentUser.getUserid()), HttpStatus.OK);
    }
    // working
    // localhost:2019/users/users
    // login with user : admin
    // password: password

    @PostMapping(value = "/users/todos/{userid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> postNewTodo(@PathVariable long userid, @RequestBody Todo todos){
        todos.setUser(userService.findUserById(userid));
        return new ResponseEntity<>(todosService.save(todos), HttpStatus.OK);
    }
    // working
//    {
//        "description": "Finish worshipping Cthulu",
//            "datestarted": "2066-06-06 06:06:06",
//            "completed": false
//    }

    @PutMapping(value = "/todoss/todosid/{todosid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@PathVariable long todosid, @RequestBody Todo todos){
        return new ResponseEntity<>(todosService.update(todos, todosid), HttpStatus.OK);
    }


}