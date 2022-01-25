package com.example.SpringBootStrap.controller;

import com.example.SpringBootStrap.model.User;
import com.example.SpringBootStrap.service.RoleService;
import com.example.SpringBootStrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
@RequestMapping("/admin/user")
public class AdminController {


    private final UserService userService;

    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }

    @GetMapping
    public String mainPage(Model model, Principal principal){
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }


    @PostMapping("/edit")
    public String updateUser(@RequestParam("id") long id,
                             @RequestParam(value = "firstname", required = false) String firstName,
                             @RequestParam(value = "lastname", required = false) String lastName,
                             @RequestParam(value = "email", required = false) String email,
                             @RequestParam(value = "password", required = false) String password,
                             @RequestParam(name = "roles", required = false) Long[] rolesId) {
        User user = userService.getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roleService.getRolesById(rolesId));
        userService.updateUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin/user";
    }

    @PostMapping("/new")
    public String newUser(@RequestParam("name") String firstName,
                          @RequestParam("lastname") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("roles") Long[] rolesId) {
        User user = new User(firstName, lastName, email, password, roleService.getRolesById(rolesId));
        userService.saveUser(user);
        return "redirect:/admin/user";
    }

}
