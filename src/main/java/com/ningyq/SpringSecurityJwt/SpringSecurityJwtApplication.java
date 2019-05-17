package com.ningyq.SpringSecurityJwt;

import com.ningyq.SpringSecurityJwt.mapper.UserRoleMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 16:41
 */
@SpringBootApplication
@MapperScan("com.ningyq.SpringSecurityJwt.mapper")
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
