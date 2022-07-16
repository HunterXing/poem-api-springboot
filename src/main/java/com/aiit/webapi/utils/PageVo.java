package com.aiit.webapi.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xingheng
 * @description 分页对象
 */
@ApiModel
@Data
public class PageVo<T> implements Serializable {

    @ApiModelProperty(notes = "总条数")
    private long total;
    @ApiModelProperty(notes = "每页条数")
    private long size;
    @ApiModelProperty(notes = "当前页")
    private long current;
    @ApiModelProperty(notes = "总页数")
    private long pages;
    @ApiModelProperty(notes = "列表数据")
    private List<T> list;

    public PageVo(IPage<T> pageInfo) {
        this.total = pageInfo.getTotal();
        this.size = pageInfo.getSize();
        this.current = pageInfo.getCurrent();
        this.pages = pageInfo.getPages();
        this.list = pageInfo.getRecords();
    }
}
