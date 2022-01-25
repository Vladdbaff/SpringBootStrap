package com.example.SpringBootStrap.dao;



import com.example.SpringBootStrap.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserByEmail(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email =: email", User.class)
                            .setParameter("email", username).getSingleResult();
    }

    @Override
    public String getPassword(User user) {
        return entityManager.find(User.class, user.getId()).getPassword();
    }


}
