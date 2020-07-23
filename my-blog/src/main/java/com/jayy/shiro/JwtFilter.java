package com.jayy.shiro;

import cn.hutool.json.JSONUtil;
import com.jayy.utils.JwtUtils;
import com.jayy.utils.Response;
import com.jayy.utils.ResponseResult;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jayy
 * @Description
 * @Date 2020/6/24 16:33
 * @Version 1.0
 */
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    JwtUtils jwtUtils;


    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(jwtToken);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse response, Object mappedValue) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取到请求头中的token
        String jwt = request.getHeader("Authorization");
        if(!StringUtils.isEmpty(jwt)){
            try {
                executeLogin(request, response);
            }catch (Exception e){}
        }
        return true;
    }
}
