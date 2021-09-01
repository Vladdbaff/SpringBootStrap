package com.example.SpringBootStrap.service;


import com.example.SpringBootStrap.dao.UserDao;
import com.example.SpringBootStrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    public UserServiceImpl(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);

    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userRepository.removeUser(id);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.saveUser(user);

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userRepository.getUserById(id);

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(s);
    }
}
