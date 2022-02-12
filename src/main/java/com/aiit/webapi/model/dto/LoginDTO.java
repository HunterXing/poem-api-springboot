package com.aiit.webapi.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xingheng
 */
@ApiModel
@Data
public class LoginDTO {
    @ApiModelProperty(notes = "用户账号")
    private String username;
    @ApiModelProperty(notes = "用户密码")
    private String password;
}
