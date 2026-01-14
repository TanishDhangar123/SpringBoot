package com.dhangar.JournalApp.controller;


import com.dhangar.JournalApp.WeatherResponse;
import com.dhangar.JournalApp.entity.JournalEntry;
import com.dhangar.JournalApp.entity.Users;
import com.dhangar.JournalApp.repository.UserRepository;
import com.dhangar.JournalApp.service.JournalEntryService;
import com.dhangar.JournalApp.service.UserService;
import com.dhangar.JournalApp.service.WeatherService;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody Users user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Users userinDb =  userService.findbyuserName(user.getUserName());

        userinDb.setUserName(user.getUserName());
        userinDb.setPassword(user.getPassword());
        userService.SaveNewUser(userinDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteUserbyId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteById(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = WeatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponse != null){
            greeting = ", Weather feels like + " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);

    }

}
