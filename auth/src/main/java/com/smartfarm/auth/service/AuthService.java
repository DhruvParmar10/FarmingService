package com.smartfarm.auth.service;

import com.smartfarm.auth.entity.User;
import com.smartfarm.auth.entity.UserRole;
import com.smartfarm.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public boolean registerUser(String username, String password, UserRole role) {
        if (userRepository.existsByUsername(username)) {
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        userRepository.save(user);
        return true;
    }
}