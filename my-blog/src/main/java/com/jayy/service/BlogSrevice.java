package com.jayy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jayy.dto.QueryBlog;
import com.jayy.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jayy.vo.PageBlog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jayy
 * @since 2020-06-22
 */
public interface BlogSrevice extends IService<Blog> {
    PageBlog getBlogByPage(int page, int size, QueryBlog queryBlog);
    PageBlog getBlogByPageAndAuthor(int page, int size, QueryBlog queryBlog);
}
