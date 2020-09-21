package com.Cutry.OAProject.service.implmenet;

import com.Cutry.OAProject.Bean.JsonResponse;
import com.Cutry.OAProject.Dao.RoleMapper;
import com.Cutry.OAProject.entity.RoleInfo;
import com.Cutry.OAProject.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Object getRoleLists(Integer pageNum, Integer pageSize) {
        JsonResponse response = new JsonResponse();
        if (pageNum < 1) pageNum = 1;
        if (pageSize < 1) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<RoleInfo> list = roleMapper.getRoleLists();
        PageInfo<RoleInfo> page = new PageInfo<>(list);
        response.setData(page);
        return response;
    }

    @Override
    public Object addRole(RoleInfo roleInfo) {
        JsonResponse response = new JsonResponse();
        roleMapper.insert(roleInfo);
        response.setData(roleInfo);
        return response;
    }

    @Override
    public Object editRole(RoleInfo roleInfo) {
        JsonResponse response = new JsonResponse();
        roleMapper.update(roleInfo);
        response.setData(roleInfo.getId());
        return response;
    }

    @Override
    public Object delRole(Long id) {
        JsonResponse response = new JsonResponse();
        roleMapper.delete(id);
        return response;
    }

    @Override
    public Object getAllRoleList() {
        JsonResponse response = new JsonResponse();
        response.setData(roleMapper.getRoleLists());
        return response;
    }
}
