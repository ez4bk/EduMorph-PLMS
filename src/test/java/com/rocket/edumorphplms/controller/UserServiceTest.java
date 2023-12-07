package com.rocket.edumorphplms.controller;
import com.rocket.edumorphplms.dto.UserDTO;
import com.rocket.edumorphplms.dto.UserType;
import com.rocket.edumorphplms.entity.User;
import com.rocket.edumorphplms.repository.UserRepository;
import com.rocket.edumorphplms.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@SpringBootTest
@Api(tags = "User Service Test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Test case for getUserById
    @Test
    @ApiOperation(value = "Get User by ID", notes = "Test to retrieve a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public void testGetUserById() {
        // Given
        Long userId = 1L;
        User user = new User();
        user.setUserId(userId);
        user.setUsername("user1");
        user.setPassword("password1");
        user.setEmail("user1@umd.edu");
        user.setUserType(UserType.Admin);
        userRepository.save(user);

        // When
        UserDTO userDTO = userService.getUserById(userId);

        // Then
        Assertions.assertEquals(userId, userDTO.getUserId());
        Assertions.assertEquals("user1", userDTO.getUsername());
        Assertions.assertEquals("password1", userDTO.getPassword());
        Assertions.assertEquals("user1@umd.edu", userDTO.getEmail());
        Assertions.assertEquals(UserType.Admin, userDTO.getUserType());
    }

    // Test case for getAllUsers
    @Test
    @ApiOperation(value = "Get All Users", notes = "Test to retrieve a list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found"),
            @ApiResponse(code = 204, message = "No users found")
    })
    public void testGetAllUsers() {

        List<UserDTO> userDTOs = userService.getAllUsers();
        // Given
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@umd.edu");
        user1.setUserType(UserType.Admin);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@umd.edu");
        user2.setUserType(UserType.Admin);
        userRepository.save(user2);

        // When
        userDTOs = userService.getAllUsers();

        // Then
        Assertions.assertEquals(user1.getUserId(), userDTOs.get(0).getUserId());
        Assertions.assertEquals(user1.getUsername(), userDTOs.get(0).getUsername());
        Assertions.assertEquals(user1.getPassword(), userDTOs.get(0).getPassword());
        Assertions.assertEquals(user1.getEmail(), userDTOs.get(0).getEmail());
        Assertions.assertEquals(user1.getUserType(), userDTOs.get(0).getUserType());
        Assertions.assertEquals(user2.getUserId(), userDTOs.get(1).getUserId());
        Assertions.assertEquals(user2.getUsername(), userDTOs.get(1).getUsername());
        Assertions.assertEquals(user2.getPassword(), userDTOs.get(1).getPassword());
        Assertions.assertEquals(user2.getEmail(), userDTOs.get(1).getEmail());
        Assertions.assertEquals(user2.getUserType(), userDTOs.get(1).getUserType());
    }

    // Test case for getUserByEmailAndPassword
    @Test
    @ApiOperation(value = "Authenticate User", notes = "Test to authenticate a user by email and password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User authenticated successfully"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public void testGetUserByEmailAndPassword() {
        // Given
        User user = new User();
        user.setUserId(1L);
        user.setUsername("user1");
        user.setPassword("password1");
        user.setEmail("user1@umd.edu");
        user.setUserType(UserType.Student);
        userRepository.save(user);

        // When
        UserDTO userDTO = userService.getUserByEmailAndPassword("user1@umd.edu", "password1");

        // Then
        Assertions.assertEquals(user.getUserId(), userDTO.getUserId());
        Assertions.assertEquals(user.getUsername(), userDTO.getUsername());
        Assertions.assertEquals(user.getPassword(), userDTO.getPassword());
        Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(user.getUserType(), userDTO.getUserType());
    }

 
}
