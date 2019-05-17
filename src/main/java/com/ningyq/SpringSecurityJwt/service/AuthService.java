package com.ningyq.SpringSecurityJwt.service;

import com.ningyq.SpringSecurityJwt.bean.User;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:36
 */
public interface AuthService {
    User register(User user);

    String login(String username, String password);
}
