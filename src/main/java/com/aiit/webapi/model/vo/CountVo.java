package com.aiit.webapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xingheng
 */
@ApiModel
@Data
public class CountVo {
    @ApiModelProperty(notes = "分类名称")
    private String name;
    @ApiModelProperty(notes = "分类数量")
    private Integer number;
}
