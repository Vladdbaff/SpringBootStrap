package com.example.SpringBootStrap.dao;



import com.example.SpringBootStrap.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRoleByName(String[] name) {
        List<String> roles = Arrays.asList(name);
        return new HashSet<Role>(entityManager.createQuery("select r from Role r where r.role in (:stringRoles)", Role.class)
                                    .setParameter("stringRoles", roles).getResultList());
    }


}
