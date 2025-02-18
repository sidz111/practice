package com.example.fingerprintapp.controller;

import com.example.fingerprintapp.entity.User;
import com.example.fingerprintapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register-user")
    public String registerUser(@RequestParam("name") String name, 
                               @RequestParam("fingerprint") String fingerprintBase64) {
        byte[] fingerprintData = Base64.getDecoder().decode(fingerprintBase64);
        User user = new User(name, fingerprintData);
        userService.saveUser(user);
        return "redirect:/";
    }

}
