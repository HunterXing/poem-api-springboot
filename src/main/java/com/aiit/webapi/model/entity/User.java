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
 * @author xingheng
 */
@ApiModel
@Data
@TableName("tb_user")
public class User {
    @ApiModelProperty(notes = "用户id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    @ApiModelProperty(notes = "用户年龄")
    private Integer age;
    @ApiModelProperty(notes = "用户email")
    private String email;
    @ApiModelProperty(notes = "用户真实姓名")
    private String name;
    @ApiModelProperty(notes = "密码")
    private String password;
    @ApiModelProperty(notes = "用户账号")
    private String account;
    @ApiModelProperty(notes = "部门id")
    private Integer deptId;
    @ApiModelProperty(notes = "用户状态，0：正常，1：禁用")
    @TableLogic
    private Integer delFlag;
}
