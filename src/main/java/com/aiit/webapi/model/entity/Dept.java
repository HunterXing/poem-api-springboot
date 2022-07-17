package com.aiit.webapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 部门
 * @author xingheng
 */
@ApiModel
@Data
@TableName("tb_dept")
public class Dept {
    @ApiModelProperty(notes = "部门id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(notes = "父部门名称, 默认是0，根节点")
    private int parentId;

    @ApiModelProperty(notes = "部门名称")
    @NotBlank(message = "部门名称不能为空")
    private String name;

    @ApiModelProperty(notes = "逻辑删除标记，0：正常，1：删除")
    @TableLogic
    private int delFlag;
}
