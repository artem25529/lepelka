package com.es.lepelka.service;

import com.es.lepelka.model.Authority;
import com.es.lepelka.model.User;
import com.es.lepelka.repository.AuthorityRepository;
import com.es.lepelka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @SuppressWarnings("all")
    public void registerUser(User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority userAuthority = authorityRepository.findAuthorityByAuthority("USER").get();
        user.setAuthorities(List.of(userAuthority));
        userRepository.save(user);
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
