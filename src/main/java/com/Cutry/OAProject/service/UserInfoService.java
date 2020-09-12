package com.Cutry.OAProject.service;

import com.Cutry.OAProject.entity.UserInfo;

public interface UserInfoService {

    void find(long id);

    Object findByUserNameAndPassword(String userName, String password);

    Object getUserInfoPageCondition(String userName, Long roleId, Integer pageNum, Integer pageSize);

    Object addUser(UserInfo userInfo);

    Object editUser(UserInfo userInfo);

    Object delUser(Long id);
}
