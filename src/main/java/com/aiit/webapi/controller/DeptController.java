package com.aiit.webapi.controller;

import com.aiit.webapi.model.dto.PageDTO;
import com.aiit.webapi.model.entity.Dept;
import com.aiit.webapi.model.vo.DeptVo;
import com.aiit.webapi.service.intf.DeptService;
import com.aiit.webapi.utils.PageVo;
import com.aiit.webapi.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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

    @ApiOperation(value = "新增部门", notes = "新增部门")
    @PostMapping
    public Response<Integer> add(
            @Valid @RequestBody Dept dept,
            BindingResult bindingResult
    ) {
        String errorMessage = validateError(bindingResult, dept);
        if(errorMessage != "") {
            return Response.error(500, errorMessage);
        }
        try {
            deptService.save(dept);
            int deptId =  dept.getId();
            return Response.success("新增部门成功", deptId);
        } catch (Exception e) {
            return Response.error(500, "新增部门失败");
        }
    }

    @ApiOperation(value = "修改部门", notes = "修改部门")
    @PutMapping
    public Response<Integer> update(
            @RequestBody Dept dept
    ) {
        if(deptService.checkNameRepeat(dept)) {
            Response.error(500, "部门名称重复");
        }
        try {
            deptService.updateById(dept);
            int deptId =  dept.getId();
            return Response.success("修改部门信息成功", deptId);
        } catch (Exception e) {
            return Response.error(500, "修改部门信息失败");
        }
    }

    public String validateError(BindingResult bindingResult, Dept dept) {
        if(bindingResult.hasErrors()) {
            return Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        }
        if(deptService.checkNameRepeat(dept)) {
            return "部门名称重复";
        }
        return "";
    }
}
