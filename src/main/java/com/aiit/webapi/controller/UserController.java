package com.aiit.webapi.controller;

import com.aiit.webapi.mapper.UserMapper;
import com.aiit.webapi.model.dto.PageDTO;
import com.aiit.webapi.model.dto.UserPageDTO;
import com.aiit.webapi.model.entity.User;
import com.aiit.webapi.utils.PageVo;
import com.aiit.webapi.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 * @description 用户 controller 层
 */
@Api(tags = "用户")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("")
    public Response<String> add(@RequestBody User user) {
        try {
            userMapper.insert(user);
            String userId = user.getId();
            return Response.success("添加成功", userId);
        } catch (Exception e) {
            return Response.error(500, "添加失败");
        }
    }

    @ApiOperation(value = "更新用户", notes = "根据id修改用户信息")
    @PutMapping("")
    public Response<String> update(@RequestBody User user) {
        try {
            userMapper.updateById(user);
            String userId = user.getId();
            return Response.success("更新成功", userId);
        } catch (Exception e) {
            return Response.error(500, "更新失败");
        }
    }
}
