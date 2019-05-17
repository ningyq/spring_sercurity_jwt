package com.ningyq.SpringSecurityJwt.service.impl;

import com.ningyq.SpringSecurityJwt.bean.User;
import com.ningyq.SpringSecurityJwt.mapper.UserMapper;
import com.ningyq.SpringSecurityJwt.mapper.UserRoleMapper;
import com.ningyq.SpringSecurityJwt.service.AuthService;
import com.ningyq.SpringSecurityJwt.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:40
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(User user) {
        final String username = user.getUsername();
        if(userMapper.findUserByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        userMapper.insertSelective(user);
        User user1 = userMapper.findUserByUsername(username);
        userRoleMapper.insertUserId(user1.getId());
        return user;
    }

    @Override
    public String login(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);

            final Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            final String token = jwtTokenUtil.generateToken(userDetails);
            return token;
        } catch (AuthenticationException e) {
            return "error";
        }

    }
}
