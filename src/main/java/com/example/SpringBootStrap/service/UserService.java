package com.example.SpringBootStrap.service;

import com.example.SpringBootStrap.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUser(long id);

    /*User getUserByName(String name);*/
}
