package com.ningyq.SpringSecurityJwt.comm;

/**
 * @Author: ningyq
 * @Date: 2019/5/15 21:03
 */
public class Const {
    /**
     * 4小时(以毫秒ms计)
     */
    public static final long EXPIRATION_TIME = 14_400_000;

    /**
     * JWT密码
     */
    public static final String SECRET = "CodeSheepSecret";

    /**
     * Token前缀
     */
    public static final String TOKEN_PREFIX = "Bearer";

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_STRING = "Authorization";
}
