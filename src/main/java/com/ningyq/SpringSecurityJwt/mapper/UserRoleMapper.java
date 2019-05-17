package com.ningyq.SpringSecurityJwt.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * @Author: ningyq
 * @Date: 2019/5/16 20:08
 */
public interface UserRoleMapper {
    @Insert("insert into user_role (user_id) values (#{userId})")
    int insertUserId(int userId);
}
