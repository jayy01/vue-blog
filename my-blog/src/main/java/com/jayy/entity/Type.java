package com.jayy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author jayy
 * @since 2020-06-22
 */
@ApiModel(value="Type对象", description="")
@TableName("type")
public class Type implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分类id")
    @TableId(value = "type_id", type = IdType.ASSIGN_UUID)
    private String typeId;

    @ApiModelProperty(value = "分类名称")
    private String typeName;

    @ApiModelProperty(value = "帖子数")
    private Integer typeBlogCount;

    @ApiModelProperty(value = "是否启用，0否1是")
    private Integer enable;

    @ApiModelProperty(value = "是否删除，0否1是")
    @TableLogic
    private Integer isDeleted;


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeBlogCount() {
        return typeBlogCount;
    }

    public void setTypeBlogCount(Integer typeBlogCount) {
        this.typeBlogCount = typeBlogCount;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Type{" +
        "typeId=" + typeId +
        ", typeName=" + typeName +
        ", typeBlogCount=" + typeBlogCount +
        ", enable=" + enable +
        ", isDeleted=" + isDeleted +
        "}";
    }
}
