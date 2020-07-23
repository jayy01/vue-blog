package com.jayy.service.impl;

import com.jayy.entity.User;
import com.jayy.mapper.UserMapper;
import com.jayy.service.UserSrevice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jayy
 * @since 2020-06-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSrevice {

}
