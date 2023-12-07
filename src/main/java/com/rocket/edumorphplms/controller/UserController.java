package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.UserDTO;
import com.rocket.edumorphplms.exception.UserNotFoundException;
import com.rocket.edumorphplms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get User by ID
    @GetMapping("/{userId}")
    @ApiOperation(value = "Get User by ID", notes = "Retrieve a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        // Call the service to retrieve a user by their ID
        UserDTO userDTO = userService.getUserById(userId);
        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            // Return a NOT_FOUND response if the user does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Users
    @GetMapping
    @ApiOperation(value = "Get All Users", notes = "Retrieve a list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users found"),
            @ApiResponse(code = 204, message = "No users found")
    })
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Call the service to retrieve all users
        List<UserDTO> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            // Return a NO_CONTENT response if no users are found
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Authenticate User
    @GetMapping("/authenticate")
    @ApiOperation(value = "Authenticate User", notes = "Authenticate a user by email and password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User authenticated successfully"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 404, message = "User not found")
    })
    public ResponseEntity<UserDTO> authenticateUser(
        @RequestParam(name = "userEmail") String email,
        @RequestParam(name = "password") String password) {
        try {
            // Attempt to authenticate the user with the provided email and password
            UserDTO userDTO = userService.getUserByEmailAndPassword(email, password);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            // Return an UNAUTHORIZED response if authentication fails
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
