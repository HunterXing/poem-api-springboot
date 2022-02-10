package com.aiit.webapi.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xingheng
 */
@ApiModel
@Data
public class PageDTO {
    @ApiModelProperty(notes = "当前显示页数")
    private Integer pageIndex;
    @ApiModelProperty(notes = "每页显示皮数")
    private Integer pageSize;
}
