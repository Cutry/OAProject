package com.Cutry.OAProject.controller;

import com.Cutry.OAProject.entity.UserInfo;
import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/getUserInfoPageCondition")
    public Object getUserInfoPageCondition(@RequestParam String userName, @RequestParam(required = false, defaultValue = "0") Long roleId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        return userInfoService.getUserInfoPageCondition(userName, roleId, pageNum, pageSize);
    }

    @PostMapping("/addUser")
    public Object addUser(@RequestParam String userName, @RequestParam String password, @RequestParam String phone,
                          @RequestParam String realName) {
        UserInfo userInfo = UserInfo.builder()
                .userName(userName)
                .password(password)
                .phone(phone)
                .realName(realName)
                .build();
        return userInfoService.addUser(userInfo);
    }

    @PostMapping("/editUser")
    public Object editUser(@RequestParam String userName, @RequestParam String password, @RequestParam String phone,
                           @RequestParam String realName, @RequestParam Long id) {
        UserInfo userInfo = UserInfo.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .phone(phone)
                .realName(realName)
                .build();
        return userInfoService.editUser(userInfo);
    }

    @PostMapping("/delUser")
    public Object delUser(@RequestParam Long id) {
        return userInfoService.delUser(id);
    }
}
