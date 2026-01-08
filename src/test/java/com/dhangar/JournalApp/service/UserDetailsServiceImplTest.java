//package com.dhangar.JournalApp.service;
//
//import com.dhangar.JournalApp.entity.Users;
//import com.dhangar.JournalApp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class UserDetailsServiceImplTest {
//
//
//    @Autowired
//    private UserDetailServiceimpl userDetailServiceimpl;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    public void loadByUsername(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                .thenReturn((Users) User.builder().username("ram").password("adiqwfa").build());
//        UserDetailsService user = userDetailServiceimpl.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//
//
//    }
//}
