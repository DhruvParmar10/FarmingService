package com.example.users.service;

import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImp implements UserService {
@Autowired
    UserRepository repo;

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }



    @Override
    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = repo.findById(id). orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return repo.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        repo.delete(existingUser);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}

