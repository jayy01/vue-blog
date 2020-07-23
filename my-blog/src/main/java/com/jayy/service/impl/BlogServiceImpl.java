package com.jayy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jayy.dto.QueryBlog;
import com.jayy.entity.Blog;
import com.jayy.mapper.BlogMapper;
import com.jayy.service.BlogSrevice;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayy.vo.PageBlog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客的服务实现类
 * @author jayy
 * @since 2020-06-22
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogSrevice {
    @Autowired
    BlogMapper blogMapper;
    @Override
    public PageBlog getBlogByPage(int page, int size,QueryBlog queryBlog) {
        //分页查询条件
        IPage<Blog> blogIPage = new Page<Blog>();
        blogIPage.setCurrent(page);
        //blogIPage.setPages(page);
        blogIPage.setSize(size);
        //查询条件
        QueryWrapper<Blog> queryWrapper = null;
        if(queryBlog != null){
            queryWrapper = new QueryWrapper<Blog>();
            if(!StringUtils.isEmpty(queryBlog.getBlogTitle())){
                queryWrapper.eq("blog_title",queryBlog.getBlogTitle());
            }
            if(!StringUtils.isEmpty(queryBlog.getBlogType())){
                queryWrapper.eq("blog_type",queryBlog.getBlogType());
            }
            if(!StringUtils.isEmpty(queryBlog.getAuthor())){
                queryWrapper.eq("author",queryBlog.getAuthor());
            }
        }
        //查询出数据
        IPage<Blog> page1 = blogMapper.selectPage(blogIPage,queryWrapper);
        //将数据封装在PageBlog对象
        PageBlog pageBlog = new PageBlog();
        Blog blog = new Blog();
        pageBlog.setBlog(page1.getRecords());
        pageBlog.setCurrentPage( page1.getCurrent());
        pageBlog.setPageSize(page1.getPages());
        pageBlog.setSize(page1.getSize());
        pageBlog.setTotalSize(page1.getTotal());
        return pageBlog;
    }

    @Override
    public PageBlog getBlogByPageAndAuthor(int page, int size, QueryBlog queryBlog) {
        //分页查询条件
        IPage<Blog> blogIPage = new Page<Blog>();
        blogIPage.setCurrent(page);
        blogIPage.setSize(size);
        //查询条件
        QueryWrapper<Blog> queryWrapper = null;
        if(queryBlog != null){
            queryWrapper = new QueryWrapper<Blog>();
            queryWrapper.eq("author",queryBlog.getAuthor());
            if(!StringUtils.isEmpty(queryBlog.getBlogTitle())){
                queryWrapper.eq("blog_title",queryBlog.getBlogTitle());
            }
            if(!StringUtils.isEmpty(queryBlog.getBlogType())){
                queryWrapper.eq("blog_type",queryBlog.getBlogType());
            }
        }
        //查询出数据
        IPage<Blog> page1 = blogMapper.selectPage(blogIPage,queryWrapper);
        //将数据封装在PageBlog对象
        PageBlog pageBlog = new PageBlog();
        Blog blog = new Blog();
        pageBlog.setBlog(page1.getRecords());
        pageBlog.setCurrentPage( page1.getCurrent());
        pageBlog.setPageSize(page1.getPages());
        pageBlog.setSize(page1.getSize());
        pageBlog.setTotalSize(page1.getTotal());
        return pageBlog;
    }
}
