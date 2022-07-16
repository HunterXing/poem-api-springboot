package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.utils.PageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

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
    PageVo findAll(Integer pageIndex, Integer pageSize);
}
