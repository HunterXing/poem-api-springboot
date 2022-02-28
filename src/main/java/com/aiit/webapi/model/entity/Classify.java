package com.aiit.webapi.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 诗词分类
 * @author xingheng
 */
@ApiModel
@Data
public class Classify {
    @ApiModelProperty(notes = "诗词分类id")
    private Integer id;
    @ApiModelProperty(notes = "诗词类别名称")
    private String classifyName;
}
