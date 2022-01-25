package com.example.SpringBootStrap.service;


import com.example.SpringBootStrap.dao.UserDao;
import com.example.SpringBootStrap.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.updateUser(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return userRepository.getUserById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(s);
    }
}
