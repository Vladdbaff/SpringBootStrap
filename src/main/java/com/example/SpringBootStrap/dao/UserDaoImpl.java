package com.example.SpringBootStrap.dao;



import com.example.SpringBootStrap.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    private final RoleDao roleDao;

    public UserDaoImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, long id) {
        User dbUser = entityManager.find(User.class, id);
        dbUser.setUsername(user.getUsername());
        dbUser.setLastName(user.getLastName());
        dbUser.setEmail(user.getEmail());
        entityManager.merge(dbUser);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUserByEmail(String username) {
        return entityManager.createQuery("select u from User u where u.email =: email", User.class)
                            .setParameter("email", username).getSingleResult();
    }

    @Override
    public String getPassword(User user) {
        return entityManager.find(User.class, user.getId()).getPassword();
    }


}
