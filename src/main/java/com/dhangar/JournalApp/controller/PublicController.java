package com.dhangar.JournalApp.controller;

import com.dhangar.JournalApp.entity.Users;
import com.dhangar.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody Users user){
        userService.SaveNewUser(user);

    }

}
