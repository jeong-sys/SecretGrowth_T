package com.swproject.swproject.service;

import com.swproject.swproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String userId, String password){
        return userRepository.findByUserId(userId).map(user -> passwordEncoder.matches(password, user.getPassword())).orElse(false);
    }
}
