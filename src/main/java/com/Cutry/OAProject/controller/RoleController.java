package com.Cutry.OAProject.controller;

import com.Cutry.OAProject.entity.RoleInfo;
import com.Cutry.OAProject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/getRoleLists")
    public Object getRoleLists(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {

        return roleService.getRoleLists(pageNum, pageSize);
    }

    @RequestMapping("/addRole")
    public Object addRole(@RequestParam String roleName, @RequestParam String roleDesc, @RequestParam String desc) {
        RoleInfo roleInfo = RoleInfo.builder()
                .roleName(roleName)
                .roleDesc(roleDesc)
                .desc(desc)
                .build();
        return roleService.addRole(roleInfo);
    }

    @RequestMapping("/editRole")
    public Object editRole(@RequestParam Long id, @RequestParam String roleName, @RequestParam String roleDesc, @RequestParam String desc) {
        RoleInfo roleInfo = RoleInfo.builder()
                .id(id)
                .roleName(roleName)
                .roleDesc(roleDesc)
                .desc(desc)
                .build();
        return roleService.editRole(roleInfo);
    }

    @RequestMapping("/delRole")
    public Object delRole(@RequestParam Long id) {
        return roleService.delRole(id);
    }

    @RequestMapping("/getAllRoleList")
    public Object getAllRoleList() {
        return roleService.getAllRoleList();
    }

}
