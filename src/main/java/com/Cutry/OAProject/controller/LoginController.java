package com.Cutry.OAProject.controller;

import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Object login(@RequestParam String userName, @RequestParam String password) {

        return userInfoService.findByUserNameAndPassword(userName, password);
    }

    @PostMapping("/userInfo/getUserInfoPageCondition")
    public Object getUserInfoPageCondition(@RequestParam(required = false) String userName, @RequestParam(required = false, defaultValue = "0") Long roleId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        return userInfoService.getUserInfoPageCondition(userName, roleId, pageNum, pageSize);
    }
}
