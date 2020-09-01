package com.Cutry.OAProject.Dao;

import com.Cutry.OAProject.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    UserInfo find(@Param("id") Long id);

    @ResultMap("UserInfoResultMap")
    @Select("select * from user_info where userName=#{userName} and password=#{password} and status=1")
    UserInfo findByUserNameAndPassword(String userName, String password);
}
