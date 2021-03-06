package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.entity.Dept;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.utils.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author xingheng
 */

public interface DeptService extends IService<Dept> {
    /**
     * 通过分页插件查询组织列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageVo findAll(Integer pageIndex, Integer pageSize);

    /**
     * 查询所有组织
     * @return
     */
    List<DeptVo> findAll();

    /**
     * 查询组织名称是否重复
     * @param  dept
     * @return
     */
    Boolean checkNameRepeat(Dept dept);
}
