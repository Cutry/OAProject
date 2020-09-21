package com.Cutry.OAProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfo implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 备注
     */
    private String desc;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 状态 1 开启  2 关闭  3 删除
     */
    private Integer status;
}
