package com.aiit.webapi;

import com.aiit.webapi.mapper.DeptMapper;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.utils.PageVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WebapiApplicationTests {
    @Resource
    private DeptMapper deptMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void findAllDept() {
        Page<DeptVo> pageParam = new Page<>(1, 10);
        IPage<DeptVo> pageInfo = deptMapper.findAll(pageParam);
        List<DeptVo> deptList =  pageInfo.getRecords();

        PageVo pageVo = new PageVo(pageInfo);

    }
}
