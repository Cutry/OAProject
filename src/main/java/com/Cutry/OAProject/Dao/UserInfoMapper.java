package com.Cutry.OAProject.Dao;

import com.Cutry.OAProject.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    UserInfo find(@Param("id") Long id);

    @ResultMap("UserInfoResultMap")
    @Select("select * from user_info where userName=#{userName} and password=#{password} and status=1")
    UserInfo findByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);

    List<UserInfo> getUserInfoPageCondition(@Param("userName") String userName,@Param("roleId") Long roleId);

    @Insert("insert into user_info (userName, password, phone, realName, status, createTime) " +
            " values (#{userInfo.userName},#{userInfo.password},#{userInfo.phone},#{userInfo.realName}, 1, unix_timestamp()) ")
    @SelectKey(before = false, keyProperty = "userInfo.id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    void insert(@Param("userInfo") UserInfo userInfo);

    @Update("update user_info set userName = #{userInfo.userName}, password = #{userInfo.password}," +
            " phone = #{userInfo.phone}, realName = #{userInfo.realName} where id = #{userInfo.id}")
    void update(@Param("userInfo") UserInfo userInfo);

    @Update("update user_info set status = 3 where id = #{id}")
    void del(@Param("id") Long id);
}
