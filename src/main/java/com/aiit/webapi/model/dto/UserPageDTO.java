package com.aiit.webapi.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xingheng
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class UserPageDTO extends PageDTO {
    @ApiModelProperty(notes = "部门id")
    private Integer deptId;
    @ApiModelProperty(notes = "用户姓名")
    private String name;
}
