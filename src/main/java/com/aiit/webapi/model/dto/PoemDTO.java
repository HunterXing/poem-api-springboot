package com.aiit.webapi.model.dto;

import com.aiit.webapi.model.entity.Poem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xingheng
 */
@Data
public class PoemDTO extends Poem {
    @ApiModelProperty(notes = "当前显示页数")
    private Integer pageIndex;
    @ApiModelProperty(notes = "每页显示皮数")
    private Integer pageSize;
}
