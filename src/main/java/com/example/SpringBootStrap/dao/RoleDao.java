package com.example.SpringBootStrap.dao;



import com.example.SpringBootStrap.model.Role;

import java.util.Set;

public interface RoleDao {

    Set<Role> getRoleByName(String[] name);

    Set<Role> getRolesById(Long[] name);



}
