package com.jayy.controller;


import com.jayy.entity.Type;
import com.jayy.service.TypeSrevice;
import com.jayy.utils.Response;
import com.jayy.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jayy
 * @since 2020-06-22
 */
@RestController
public class TypeController {

    @Autowired
    TypeSrevice typeSrevice;
    @PostMapping(value = "/type/save")
    public ResponseResult saveType(@RequestBody Type type){
        typeSrevice.save(type);
        return Response.makeOKRsp();
    }
    /*获取全部的文档类型*/
    @GetMapping(value = "/types")
    public ResponseResult<List> getTypes(){
        List<Type> typeList = typeSrevice.list();
        return Response.makeOKRsp(typeList);
    }
}

