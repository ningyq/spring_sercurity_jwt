package com.ningyq.SpringSecurityJwt.mapper;

import com.ningyq.SpringSecurityJwt.bean.Role;
import com.ningyq.SpringSecurityJwt.bean.User;
import com.ningyq.SpringSecurityJwt.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 16:41
 */
public interface UserMapper extends MyMapper<User> {
    @Select("select * from user where username = #{username}")
    User findUserByUsername(String username);

    User loadUserByUsername(String username);

    List<Role> getUserRolesByUserId(Integer id);
}
