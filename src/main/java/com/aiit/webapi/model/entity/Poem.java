package com.aiit.webapi.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 诗词
 * @author xingheng
 */
@ApiModel
@Data
public class Poem {
    @ApiModelProperty(notes = "诗词id")
    private String id;
    @ApiModelProperty(notes = "诗词标题")
    private String title;
    @ApiModelProperty(notes = "诗词作者")
    private String author;
    @ApiModelProperty(notes = "诗词章")
    private String chapter;
    @ApiModelProperty(notes = "诗词回")
    private String section;
    @ApiModelProperty(notes = "诗词分类外键id")
    private String classifyId;
    @ApiModelProperty(notes = "诗词内容")
    private String content;
    @ApiModelProperty(notes = "诗词录入时间")
    private String createTime;
    @ApiModelProperty(notes = "诗词图片")
    private String poemImg;
    @ApiModelProperty(notes = "诗词是否发版")
    private Boolean isPublish;
    @ApiModelProperty(notes = "诗词热度")
    private Integer hot;
}
