package com.ningyq.SpringSecurityJwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 16:41
 */
@RestController
public class TestController {

    /**
     * 测试普通权限
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_user')")
    @GetMapping("/user/test")
    public String test1() {
        return "ROLE_NORMAL /normal/test接口调用成功！";
    }

    /**
     * 测试管理员权限
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_admin')")
    @GetMapping("/admin/test")
    public String test2() {
        return "ROLE_ADMIN /admin/test接口调用成功！";
    }
}
