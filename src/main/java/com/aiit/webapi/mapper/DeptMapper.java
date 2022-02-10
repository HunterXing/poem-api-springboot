package com.aiit.webapi.mapper;

import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.model.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xingheng
 */
@Mapper
public interface DeptMapper {
    /**
     * 查找用户 通过分页插件
     * @return
     */
    List<DeptVo> findAll();
}
