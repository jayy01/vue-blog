package com.jayy.dto;

import java.io.Serializable;

/**
 * @Author jayy
 * @Description 博客查询条件
 * @Date 2020/6/23 11:28
 * @Version 1.0
 */
public class QueryBlog implements Serializable {
    //当前页
    private Integer currentPage;
    //显示大小
    private Integer size;
    //标题
    private String blogTitle;
    //类型
    private String blogType;
    //作者
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
