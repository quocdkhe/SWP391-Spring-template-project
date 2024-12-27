package com.example.swp391.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.swp391.domain.Role;
import com.example.swp391.domain.User;
import com.example.swp391.service.RoleService;
import com.example.swp391.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/user")
    public String getUserManagerPage(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "admin/userManager";
    }

    @GetMapping("/admin/user/add")
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping("/admin/user/add")
    public String postMethodName(@ModelAttribute User user) {
        Role role = roleService.findRoleByName(user.getRole().getName());
        user.setRole(role);
        userService.addNewUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String getEditUserPage(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

}
