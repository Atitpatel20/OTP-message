package com.otpmessage.controller;

import com.otpmessage.entity.User;
import com.otpmessage.service.EmailService;
import com.otpmessage.service.EmailVerificationService;
import com.otpmessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/register")
    public Map<String,String>registerUser(@RequestBody User user){
        User registerUser=userService.registerUser(user);
        Map<String, String> response = emailService.sendOtpEmail(user.getEmail());
        return response;
    }
    //http://localhost:8080/api/verify-otp?email=&otp=
    @PostMapping("/verify-otp")
    public Map<String, String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        Map<String, String> response = emailVerificationService.verifyOtp(email, otp);
        return response;
    }
}
