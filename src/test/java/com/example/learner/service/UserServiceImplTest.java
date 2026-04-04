package com.example.learner.service;

import com.example.learner.dto.UserRegistrationDto;
import com.example.learner.model.User;
import com.example.learner.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceImpl userService;

    UserRegistrationDto userData = new UserRegistrationDto();


    @Test
    void registerUser() {
        userData.setUsername("name");
        userData.setPassword("password");
        Mockito.when(userRepository.findByUsername(userData.getUsername())).thenReturn(null);
        Mockito.when(passwordEncoder.encode(userData.getPassword())).thenReturn("hashed");
        User user = new User(userData.getUsername(), "hashed");
        userService.registerUser(userData);
        //verify(userRepository, times(1)).save(any(User.class));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void registerExistingUser() {
        userData.setUsername("name");
        userData.setPassword("password");
        User user = new User(userData.getUsername(), "hashed");
        Mockito.when(userRepository.findByUsername(userData.getUsername())).thenReturn(user);
        assertThrows(IllegalArgumentException.class, () -> {userService.registerUser(userData);});
    }

    @Test
    void findByUsername(){
        String username = "name";
        User user = new User(username, "password");
        Mockito.when(userRepository.findByUsername(username)).thenReturn(user);
        assertEquals(userService.findByUsername(username), user);
    }

    @Test
    void findByUsernameNonexisting(){
        String username = "name";
        Mockito.when(userRepository.findByUsername(username)).thenReturn(null);
        assertNull(userService.findByUsername(username));
    }
    
}