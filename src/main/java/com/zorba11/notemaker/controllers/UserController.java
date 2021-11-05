package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.models.User;
import com.zorba11.notemaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
