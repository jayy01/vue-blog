package com.jayy.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.jayy.entity.User;
import com.jayy.service.UserSrevice;
import com.jayy.utils.JwtUtils;
import com.jayy.vo.UserVo;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author jayy
 * @Description
 * @Date 2020/6/24 16:18
 * @Version 1.0
 */
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserSrevice userSrevice;
    /*支持jwtToken*/
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
    /*权限信息*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /*身份验证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        Claims claim = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal());
        String userId = claim.getSubject();
        User user = userSrevice.getById(userId);
        if (user == null){
            throw  new UnknownAccountException("账户不存在");
        }
        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user,userVo);
        return new SimpleAuthenticationInfo(userVo,jwtToken.getCredentials(),getName());
    }
}
