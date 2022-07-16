package com.aiit.webapi;

import com.aiit.webapi.mapper.DeptMapper;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.service.intf.DeptService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class WebapiApplicationTests {
    @Resource
    private DeptService deptService;

    @Test
    void contextLoads() {
    }

    @Test
    public void findAll(){
        IPage<DeptVo> deptList = deptService.findAll(1, 10);
        System.out.println(deptList);
    }
}
