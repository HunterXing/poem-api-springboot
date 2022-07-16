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
    @GetMapping("/page")
    public Response<PageVo> findAll(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        PageVo deptList = deptService.findAll(pageIndex, pageSize);
        return Response.success(deptList);
    }

    @ApiOperation(value = "查询所有部门", notes = "查询所有部门")
    @GetMapping("/list")
    public Response<List> findAll() {
        List deptList = deptService.findAll();
        return Response.success(deptList);
    }
}
