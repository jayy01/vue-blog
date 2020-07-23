package com.jayy.service.impl;

import com.jayy.entity.Type;
import com.jayy.mapper.TypeMapper;
import com.jayy.service.TypeSrevice;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeSrevice {

}
