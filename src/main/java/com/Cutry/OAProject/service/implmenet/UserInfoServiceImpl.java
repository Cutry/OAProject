package com.Cutry.OAProject.service.implmenet;

import com.Cutry.OAProject.Bean.JsonResponse;
import com.Cutry.OAProject.Dao.UserInfoMapper;
import com.Cutry.OAProject.entity.UserInfo;
import com.Cutry.OAProject.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        System.out.println("userName: " + userName + "; password : " + password);
        UserInfo userInfo = userInfoMapper.findByUserNameAndPassword(userName, password);
        if (userInfo != null && userInfo.getId() > 0) {
            userInfo.setPassword("");
            response.setData(userInfo);
        } else {
            response.setFalseAndMessage("账号或密码错误！");
        }
        return response;
    }

    @Override
    public Object getUserInfoPageCondition(String userName, Long roleId, Integer pageNum, Integer pageSize) {
        JsonResponse response = new JsonResponse();
        if (pageNum < 1) pageNum = 1;
        if (pageSize < 1) pageSize = 10;
        System.out.println("pageNum: " + pageNum);
        System.out.println("pageSize: " + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = userInfoMapper.getUserInfoPageCondition(userName, roleId);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        response.setData(pageInfo);
        return response;
    }

    @Override
    public Object addUser(UserInfo userInfo) {
        JsonResponse response = new JsonResponse();
        userInfoMapper.insert(userInfo);
        response.setData(userInfo);
        return response;
    }

    @Override
    public Object editUser(UserInfo userInfo) {
        JsonResponse response = new JsonResponse();
        userInfoMapper.update(userInfo);
        return response;
    }

    @Override
    public Object delUser(Long id) {
        JsonResponse response = new JsonResponse();
        userInfoMapper.del(id);
        return response;
    }
}
