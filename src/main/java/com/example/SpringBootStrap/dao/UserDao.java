package com.example.SpringBootStrap.dao;





import com.example.SpringBootStrap.model.User;

import java.util.List;

public interface UserDao {

     void saveUser(User user);

     void updateUser(User user, long id);

     void removeUser(long id);

     User getUserById(long id);

     List<User> getAllUsers();

     User getUserByEmail(String username);

     String getPassword(User user);
}
