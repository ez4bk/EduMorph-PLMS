package com.rocket.edumorphplms.controller;

import com.rocket.edumorphplms.dto.AccountInfoDTO;
import com.rocket.edumorphplms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Define endpoint to fetch account information by username
    @GetMapping("/{username}")
    public AccountInfoDTO getAccountInfo(@PathVariable String username) {
        return accountService.getAccountInfo(username);
    }
}
