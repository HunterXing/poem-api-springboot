package com.aiit.webapi.service.impl;

import com.aiit.webapi.mapper.DeptMapper;
import com.aiit.webapi.mapper.UserMapper;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.model.vo.UserInfoVo;
import com.aiit.webapi.service.intf.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    public PageInfo<DeptVo> findAll(Integer pageIndex, Integer pageSize) {
        // 分页
        PageHelper.startPage(pageIndex,pageSize);
        //查询分组列表
        List<DeptVo> list = deptMapper.findAll();
        // 获取分页信息
        PageInfo<DeptVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<DeptVo> findAll() {
        //查询分组列表
        List<DeptVo> list = deptMapper.findAll();
        // 获取分页信息
        PageInfo<DeptVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
