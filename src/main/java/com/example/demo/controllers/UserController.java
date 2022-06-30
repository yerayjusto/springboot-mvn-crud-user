package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getByPriority(priority);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String  deleteById(@PathVariable("id") Long id) {
        boolean user = this.userService.deleteUser(id);
        if (user) {
            return "User deleted";
        } else {
            return "Can't delete user " + id;
        }
    }
}
