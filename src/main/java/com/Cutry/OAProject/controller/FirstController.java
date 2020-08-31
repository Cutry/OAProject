package com.Cutry.OAProject.controller;

import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstPage")
public class FirstController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/test1")
    public String test1() {
        userInfoService.find(1L);
        return "1111";
    }
}
