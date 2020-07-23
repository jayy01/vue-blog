package com.jayy.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author jayy
 * @Description 自动注入创建时间 和最后更新时间
 * @Date 2020/6/23 14:46
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "creationDate", LocalDateTime.class, LocalDateTime.now());
        this.fillStrategy(metaObject, "creationDate", LocalDateTime.now());
        this.strictUpdateFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
        this.fillStrategy(metaObject, "lastUpdateDate", LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "lastUpdateDate", LocalDateTime.class, LocalDateTime.now());
        this.fillStrategy(metaObject, "lastUpdateDate", LocalDateTime.now());
    }
}
