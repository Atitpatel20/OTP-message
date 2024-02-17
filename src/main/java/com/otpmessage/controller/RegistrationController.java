package com.otpmessage.controller;

import com.otpmessage.entity.User;
import com.otpmessage.service.EmailService;
import com.otpmessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public Map<String,String>registerUser(@RequestBody User user){
        User registerUser=userService.registerUser(user);
        return null;
    }
}
