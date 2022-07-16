package com.aiit.webapi.mapper;

import com.aiit.webapi.model.vo.DeptVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xingheng
 */
@Mapper
public interface DeptMapper {
    /**
     * 查找组织 通过分页插件
     * @return
     */
    IPage<DeptVo> findAll(Page<?> page);
}
