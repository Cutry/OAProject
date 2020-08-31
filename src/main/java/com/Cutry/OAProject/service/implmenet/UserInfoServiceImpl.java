package com.Cutry.OAProject.service.implmenet;

import com.Cutry.OAProject.Dao.UserInfoMapper;
import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void find(long l) {
        System.out.println(userInfoMapper.find(l));
    }
}
