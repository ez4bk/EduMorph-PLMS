package com.rocket.edumorphplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rocket.edumorphplms.repository.UserRepository;
import com.rocket.edumorphplms.dto.UserDTO;
import com.rocket.edumorphplms.entity.User;

import java.util.Collections;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public UserDTO getUserById(Long userId) {
        // Fetch user from userRepository by userId

        List<User> users = userRepository.findAllById(Collections.singletonList(userId));
        User user = users.isEmpty() ? null : users.get(0);

        if (user == null) {
            // Handle user not found
            return null;
        }

        // Convert the User entity to UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());

        return userDTO;
    }
}
