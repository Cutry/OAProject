package com.Cutry.OAProject.controller;

import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/login")
    public Object login(@RequestParam String userName, @RequestParam String password) {

        return userInfoService.findByUserNameAndPassword(userName, password);
    }
}
