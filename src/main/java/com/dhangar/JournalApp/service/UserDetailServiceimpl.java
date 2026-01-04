package com.dhangar.JournalApp.service;

import com.dhangar.JournalApp.entity.Users;
import com.dhangar.JournalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceimpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);

        if(user != null) {
         UserDetails userDetails = User.builder()
                    .username(user.getUserName())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();

         return userDetails;
        }
        throw new UsernameNotFoundException("User not found exception" + username);
    }
}
