package com.zorba11.notemaker.controllers;

import com.zorba11.notemaker.dtos.NoteDTO;
import com.zorba11.notemaker.dtos.UserDTO;
import com.zorba11.notemaker.models.User;
import com.zorba11.notemaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        System.out.println("hi there!");

        return userService.getAllUsers();
    }

//    @GetMapping(value = "/all")
//    public List<User> getAllUsersWithoutDto() {
//        return userService.getAllUsersWithoutDto();
//    }



    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping(value = "/search/{searchStr}")
    public List<NoteDTO> findAllOtherNotesOfUsers(@PathVariable(value = "searchStr") String searchStr) {
        return userService.findAllOtherNotesOfUsers(searchStr);
    }


}
