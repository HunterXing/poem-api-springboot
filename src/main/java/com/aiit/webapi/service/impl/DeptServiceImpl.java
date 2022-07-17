package com.aiit.webapi.service.impl;

import com.aiit.webapi.mapper.DeptMapper;
import com.aiit.webapi.model.entity.Dept;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.service.intf.DeptService;
import com.aiit.webapi.utils.PageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Resource
    private DeptMapper deptMapper;
    @Override
    public PageVo findAll(Integer pageIndex, Integer pageSize) {
        Page<DeptVo> pageParam = new Page<>(pageIndex, pageSize);
        IPage<DeptVo> pageInfo = deptMapper.findAll(pageParam);
        List<DeptVo> deptList =  pageInfo.getRecords();

        PageVo pageVo = new PageVo(pageInfo);

        // 获取分页信息
        return pageVo;
    }

    @Override
    public List<DeptVo> findAll() {
        List<DeptVo> deptList = deptMapper.findAll();
        return deptList;
    }

    /**
     * @param dept
     * @return
     */
    @Override
    public Boolean checkNameRepeat(Dept dept) {
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dept::getName, dept.getName());
        return count(queryWrapper) > 0;
    }
}
