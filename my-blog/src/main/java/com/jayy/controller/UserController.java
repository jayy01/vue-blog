package com.jayy.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jayy.dto.LoginUser;
import com.jayy.entity.Blog;
import com.jayy.entity.User;
import com.jayy.service.UserSrevice;
import com.jayy.utils.JwtUtils;
import com.jayy.utils.Response;
import com.jayy.utils.ResponseResult;
import com.jayy.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jayy
 * @since 2020-06-22
 */
@RestController
public class UserController {

    @Autowired
    UserSrevice userSrevice;
    @Autowired
    JwtUtils jwtUtils;

    /*登录*/
    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseResult<UserVo> login(@RequestBody LoginUser loginUser,HttpServletResponse response){
        //获取用户
        User user = userSrevice.getOne(new QueryWrapper<User>().eq("username", loginUser.getUsername()));
        //判断用户名密码
        Assert.notNull(user,"用户名密码错误！");
        System.out.println("登录"+loginUser.getPassword());
        System.out.println("登录"+SecureUtil.md5(loginUser.getPassword()));
        if(!user.getPassword().equals(SecureUtil.md5(loginUser.getPassword()))){
            return new Response().makeErrRsp("用户名密码错误！");
        }
        //生成jwt
        String jwt = jwtUtils.generateToken(user.getUserId());
        //将jwt返回
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        //将user的信息拷贝到uservo中
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return new Response().makeOKRsp(userVo);
    }
    /*退出*/
    @GetMapping(value = "/logout")
    public ResponseResult logout(){
        SecurityUtils.getSubject().logout();
        return new Response().makeOKRsp();
    }
    @PostMapping(value = "/register")
    public ResponseResult<User> register(@RequestBody User user){
        //判断用户是否存在
        User exitUser = userSrevice.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if(exitUser != null){
            return new Response().makeErrRsp("用户名已存在");
        }
        //获取密码加密
        String password = user.getPassword();
        user.setPassword(SecureUtil.md5(password));
        boolean save = userSrevice.save(user);
        if(save){
            return new Response().makeOKRsp();
        }
        return new Response().makeErrRsp("注册失败,请重试");
    }
    /*获取用户信息*/
    @GetMapping(value = "/info/userId")
    public ResponseResult getUserInfo(@PathVariable String userId){
        User user = userSrevice.getById(userId);
        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user,userVo);
        return Response.makeOKRsp(userVo);
    }
}