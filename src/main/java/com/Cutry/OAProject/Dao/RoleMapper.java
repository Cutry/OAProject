package com.Cutry.OAProject.Dao;

import com.Cutry.OAProject.entity.RoleInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    @ResultMap("RoleInfoResultMap")
    @Select("select * from role_info order by createTime desc ")
    List<RoleInfo> getRoleLists();

    @Insert(" insert into role_info (roleName, roleDesc, desc, status, createTime) " +
            " values (#{role.roleName},#{role.roleDesc},#{role.desc}, 1, unix_timestamp()) ")
    @SelectKey(before = false, keyProperty = "role.id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    void insert(@Param("role") RoleInfo roleInfo);

    @Update(" update role_info set roleName = #{role.roleName}, roleDesc = #{role.roleDesc}, " +
            " desc = #{role.desc} where id = #{role.id} ")
    void update(@Param("role") RoleInfo roleInfo);

    @Update(" update role_info set status = 3 where id = #{id}")
    void delete(@Param("id") Long id);
}
