package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.model.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;

/**
 * @author xingheng
 */

public interface DeptService {
    /**
     * 通过分页插件查询组织列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<DeptVo> findAll(Integer pageIndex, Integer pageSize);
    /**
     * 查询所有组织
     * @return
     */
    PageInfo<DeptVo> findAll();
}
