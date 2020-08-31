package com.Cutry.OAProject.Dao;

import com.Cutry.OAProject.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    UserInfo find(@Param("id") Long id);
}
