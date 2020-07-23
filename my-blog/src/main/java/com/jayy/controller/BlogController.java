package com.jayy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jayy.dto.QueryBlog;
import com.jayy.entity.Blog;
import com.jayy.service.BlogSrevice;
import com.jayy.utils.Response;
import com.jayy.utils.ResponseResult;
import com.jayy.vo.PageBlog;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客请求
 * @author jayy
 * @since 2020-06-22
 */
@RestController
public class BlogController {
    @Autowired
    BlogSrevice blogSrevice;

    /*分页查询*/
    @GetMapping(path = "/blogs/{page}/{size}")
    public ResponseResult<PageBlog> getBlogByPage(@PathVariable Integer page,@PathVariable Integer size){
        PageBlog blogByPage = blogSrevice.getBlogByPage(page, size,null);
        return Response.makeOKRsp(blogByPage);
    }
    @GetMapping(path = "/blogs")
    public ResponseResult<PageBlog> getBlogByPage(){
        PageBlog blogByPage = blogSrevice.getBlogByPage(1, 5,null);
        return Response.makeOKRsp(blogByPage);
    }
    /*分页带条件查询*/
    @PostMapping(path = "/blogs")
    public ResponseResult<PageBlog> getBlogByPage(@RequestBody QueryBlog queryBlog){
        PageBlog blogByPage = blogSrevice.getBlogByPage(queryBlog.getCurrentPage(), queryBlog.getSize(),queryBlog);
        return Response.makeOKRsp(blogByPage);
    }
    /*明细查询*/
    @GetMapping(path = "/blog/{blogId}")
    public ResponseResult<Blog> getBlogByDetail(@PathVariable(name = "blogId") String blogId){
        Blog blog = blogSrevice.getOne(new QueryWrapper<Blog>().eq("blog_id",blogId));
        return Response.makeOKRsp(blog);
    }
    /*编辑*/
    @RequiresAuthentication
    @PutMapping(path = "/blog/edit")
    public ResponseResult<Blog> updateBlog(@RequestBody Blog blog){
        //乐观锁
        Blog oldBlog = blogSrevice.getById(blog.getBlogId());
        blog.setVersion(oldBlog.getVersion());
        //返回时用
        blog.setIsDeleted(oldBlog.getIsDeleted());
        blog.setCreationDate(oldBlog.getCreationDate());
        boolean update = blogSrevice.updateById(blog);
        if(update){
            return Response.makeOKRsp(blog);
        }else {
            return Response.makeErrRsp("更新失败，请重试");
        }

    }
    /*新增*/
    @RequiresAuthentication
    @PostMapping(path = "/blog/save")
    public ResponseResult saveBlog(@RequestBody Blog blog){
        boolean save = blogSrevice.save(blog);
        return Response.makeOKRsp();
    }
    /*删除*/
    @RequiresAuthentication
    @DeleteMapping(path = "/blog/delete/{blogId}")
    public ResponseResult deleteBlog(@PathVariable String blogId){
        boolean delete = blogSrevice.removeById(blogId);
        if(delete){
            return Response.makeOKRsp();
        }else{
            return Response.makeErrRsp("删除失败，请重试");
        }
    }
    /*分页带条件查询个人*/
    @RequiresAuthentication
    @PostMapping(path = "/myblogs")
    public ResponseResult<PageBlog> getBlogByPageAndAuthor(@RequestBody QueryBlog queryBlog){
        PageBlog blogByPage = blogSrevice.getBlogByPageAndAuthor(queryBlog.getCurrentPage(), queryBlog.getSize(),queryBlog);
        return Response.makeOKRsp(blogByPage);
    }
    //根据类型分页查询
    /*分页查询*/
    @GetMapping(path = "/typeBlogs/{page}/{size}/{typeId}")
    public ResponseResult<PageBlog> getBlogByType(@PathVariable Integer page,@PathVariable Integer size,@PathVariable String typeId){
        Page<Blog> objectPage = new Page<>();
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<Blog>().eq("blog_type", typeId);
        Page<Blog> page1 = blogSrevice.page(objectPage, queryWrapper);
        PageBlog pageBlog = new PageBlog();
        pageBlog.setBlog(page1.getRecords());
        pageBlog.setCurrentPage( page1.getCurrent());
        pageBlog.setPageSize(page1.getPages());
        pageBlog.setSize(page1.getSize());
        pageBlog.setTotalSize(page1.getTotal());
        return Response.makeOKRsp(pageBlog);
    }


}

