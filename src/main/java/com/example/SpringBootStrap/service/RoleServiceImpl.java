package com.example.SpringBootStrap.service;

import com.example.SpringBootStrap.dao.RoleDao;
import com.example.SpringBootStrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{


    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<Role> getRoleByName(String[] name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Set<Role> getRolesById(Long[] rolesId) {
        return roleDao.getRolesById(rolesId);
    }
}
