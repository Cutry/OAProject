package com.Cutry.OAProject.service.implmenet;

import com.Cutry.OAProject.Bean.JsonResponse;
import com.Cutry.OAProject.Dao.UserInfoMapper;
import com.Cutry.OAProject.entity.UserInfo;
import com.Cutry.OAProject.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void find(long id) {
        System.out.println(userInfoMapper.find(id));
    }

    @Override
    public Object findByUserNameAndPassword(String userName, String password) {
        JsonResponse response = new JsonResponse();
        UserInfo userInfo = userInfoMapper.findByUserNameAndPassword(userName, password);
        if (userInfo != null && userInfo.getId() > 0) {
            userInfo.setPassword("");
            response.setData(userInfo);
        } else {
            response.setFalseAndMessage("账号或密码错误！");
        }
        return response;
    }
}
