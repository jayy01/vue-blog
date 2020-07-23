package com.jayy.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

/**
 * @author jayy
 * @since 2020-06-22
 */
@ApiModel(value="Blog对象", description="博客")
@TableName("blog")
public class Blog implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "博客id")
    @TableId(type = IdType.ASSIGN_ID)
    private String blogId;

    @ApiModelProperty(value = "标题")
    private String blogTitle;

    @ApiModelProperty(value = "封面")
    private String blogImage;

    @ApiModelProperty(value = "内容")
    private String blogContent;

    @ApiModelProperty(value = "点赞数")
    private Integer blogGoods;

    @ApiModelProperty(value = "阅读数")
    private Integer blogRead;

    @ApiModelProperty(value = "收藏数")
    private Integer blogCollection;

    @ApiModelProperty(value = "博客类型")
    private String  blogType;

    @ApiModelProperty(value = "简介")
    private String blogRemark;

    @ApiModelProperty(value = "评论数")
    private Integer blogComment;

    @ApiModelProperty(value = "文档来源")
    private String blogSource;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastUpdateDate;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getBlogGoods() {
        return blogGoods;
    }

    public void setBlogGoods(Integer blogGoods) {
        this.blogGoods = blogGoods;
    }

    public Integer getBlogRead() {
        return blogRead;
    }

    public void setBlogRead(Integer blogRead) {
        this.blogRead = blogRead;
    }

    public Integer getBlogCollection() {
        return blogCollection;
    }

    public void setBlogCollection(Integer blogCollection) {
        this.blogCollection = blogCollection;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getBlogRemark() {
        return blogRemark;
    }

    public void setBlogRemark(String blogRemark) {
        this.blogRemark = blogRemark;
    }

    public Integer getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(Integer blogComment) {
        this.blogComment = blogComment;
    }

    public String getBlogSource() {
        return blogSource;
    }

    public void setBlogSource(String blogSource) {
        this.blogSource = blogSource;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
