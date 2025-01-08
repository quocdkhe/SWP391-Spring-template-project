package com.example.swp391.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swp391.domain.User;
import com.example.swp391.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void handleSaveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public boolean checkExistedUsername(String username){
        return userRepository.findByUsername(username) != null;
    }
}
