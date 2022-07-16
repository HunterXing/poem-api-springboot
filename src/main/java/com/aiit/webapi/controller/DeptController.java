package com.aiit.webapi.controller;

import com.aiit.webapi.model.dto.PageDTO;
import com.aiit.webapi.service.intf.DeptService;
import com.aiit.webapi.utils.PageVo;
import com.aiit.webapi.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 */
@Api(tags = "部门相关api")
@CrossOrigin
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @ApiOperation(value = "分页查询部门列表", notes = "分页查询部门列表")
    @PostMapping("/list")
    public Response<PageVo> findAll(@RequestBody PageDTO pageDTO) {
        PageVo deptList = deptService.findAll(pageDTO.getPageIndex(), pageDTO.getPageSize());
        return Response.success(deptList);
    }

    @ApiOperation(value = "查询所有部门", notes = "查询所有部门")
    @PostMapping("/list/all")
    public Response<List> findAll() {
        List deptList = deptService.findAll();
        return Response.success(deptList);
    }
}
