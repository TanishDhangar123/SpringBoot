package com.dhangar.JournalApp.service;

import com.dhangar.JournalApp.entity.JournalEntry;
import com.dhangar.JournalApp.entity.Users;
import com.dhangar.JournalApp.repository.JournalEntryRepository;
import com.dhangar.JournalApp.repository.UserRepository;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {


    @Autowired
    private UserRepository userRepository; //This is an example of implementation of an Interface

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Users SaveNewUser(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        return userRepository.save(user);

    }

    public Users saveUser(Users user){
        return userRepository.save(user);
    }

    public Users SaveNewAdmin(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        return userRepository.save(user);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    //Optional is like a box where we can either return a value or we can return nothing i.e null
    public Optional<Users> findByid(ObjectId id){
        return userRepository.findById(id);
    }

    public void deletebyId(ObjectId id){
        userRepository.deleteById(id);
    }

    public Users findbyuserName(String UserName){
        return userRepository.findByUserName(UserName);
    }
}
