package com.Cutry.OAProject.service;

public interface UserInfoService {

    void find(long id);

    Object findByUserNameAndPassword(String userName, String password);

    Object getUserInfoPageCondition(String userName, Long roleId, Integer pageNum, Integer pageSize);
}
