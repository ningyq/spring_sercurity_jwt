package com.ningyq.SpringSecurityJwt.controller;

import com.ningyq.SpringSecurityJwt.bean.Result;
import com.ningyq.SpringSecurityJwt.bean.User;
import com.ningyq.SpringSecurityJwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:35
 */
@RestController
@RequestMapping("/authentication")
public class JwtAuthController {
    @Autowired
    private AuthService authService;

    /**
     * 登录，获取Token
     * @param username 用户名
     * @param password 密码
     * @return Token
     */
    @PostMapping("/login")
    public Result createToken(@RequestParam String username,@RequestParam String password) throws AuthenticationException {
        String result = authService.login(username, password);
        if ("error".equals(result)) {
            return new Result("error", "账户或密码错误！");
        }
        return new Result("success", "登录成功", result);
    }

    /**
     * 注册新用户
     * @param user 用户对象
     * @return 注册对象
     * @throws AuthenticationException
     */
    @PostMapping("/register")
    public Result register(User user) throws AuthenticationException {
        User result = authService.register(user);
        if (result == null) {
            return new Result("error", "账户已存在！");
        }
        return new Result("success", "注册成功", result);
    }
}
