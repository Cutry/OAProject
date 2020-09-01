package com.Cutry.OAProject.service;

public interface UserInfoService {

    void find(long id);

    Object findByUserNameAndPassword(String userName, String password);
}
