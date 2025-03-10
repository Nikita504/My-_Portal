package com.java.jquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.jquery.model.User;
import com.java.jquery.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

	public void registerUser(User user) {
		userRepository.save(user);
	}

}
