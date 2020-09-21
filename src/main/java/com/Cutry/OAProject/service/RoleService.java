package com.Cutry.OAProject.service;

import com.Cutry.OAProject.entity.RoleInfo;

public interface RoleService {

    Object getRoleLists(Integer pageNum, Integer pageSize);

    Object addRole(RoleInfo roleInfo);

    Object editRole(RoleInfo roleInfo);

    Object delRole(Long id);

    Object getAllRoleList();
}
