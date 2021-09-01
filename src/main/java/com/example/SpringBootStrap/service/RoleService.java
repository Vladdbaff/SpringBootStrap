package com.example.SpringBootStrap.service;

import com.example.SpringBootStrap.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getRoleByName(String[] name);
}
