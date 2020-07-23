package com.jayy.vo;

import com.jayy.entity.Blog;

import java.io.Serializable;
import java.util.List;

/**
 * @Author jayy
 * @Description 博客的查询的页面显示
 * @Date 2020/6/23 11:21
 * @Version 1.0
 */

public class PageBlog  implements Serializable {
    //当前页
    private Long currentPage;
    //当前页显示大小
    private Long size;
    //总条数
    private Long totalSize;
    //总页数
    private Long pageSize;
    //博客对象
    private List<Blog>  blog;

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }
}
