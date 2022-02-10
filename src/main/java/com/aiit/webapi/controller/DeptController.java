package com.aiit.webapi.controller;

import com.aiit.webapi.model.dto.PageDTO;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.service.intf.DeptService;
import com.aiit.webapi.utils.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public Response<PageInfo<DeptVo>> findAll(@RequestBody PageDTO pageDTO) {
        PageInfo<DeptVo> deptList = deptService.findAll(pageDTO.getPageIndex(), pageDTO.getPageSize());
        return Response.success(deptList);
    }

    @ApiOperation(value = "查询部门所有列表", notes = "查询部门所有列表")
    @GetMapping("/list")
    public Response<PageInfo<DeptVo>> findAll() {
        PageInfo<DeptVo> deptList = deptService.findAll();
        return Response.success(deptList);
    }
}
