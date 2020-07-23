package com.jayy.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author jayy
 * @Description
 * @Date 2020/6/24 16:35
 * @Version 1.0
 */
public class JwtToken implements AuthenticationToken  {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
