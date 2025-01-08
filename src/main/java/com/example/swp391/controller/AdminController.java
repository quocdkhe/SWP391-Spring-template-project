package com.example.swp391.controller;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.swp391.domain.Role;
import com.example.swp391.domain.User;
import com.example.swp391.service.RoleService;
import com.example.swp391.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user")
    public String getUserManagerPage(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "admin/userManager";
    }

    @GetMapping("/user/add")
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping("/user/add")
    public String handleAddUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/admin/addUser";
        }
        Role role = roleService.findRoleByName(user.getRole().getName());
        user.setRole(role);
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/edit/{id}")
    public String getUpdateUserPage(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @PostMapping("/user/edit")
    public String handleUpdateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "admin/editUser";
        }
        User currentUser = userService.getUserById(user.getId());
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());
        currentUser.setJob(user.getJob());
        currentUser.setRole(roleService.findRoleByName(user.getRole().getName()));
        currentUser.setDob(user.getDob());
        userService.handleSaveUser(currentUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/user/delete/{id}")
    public String handleDeleteUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        userService.deleteUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/blank")
    public String getMethodName() {
        return "admin/index";
    }
    
    

}
