package com.aiit.webapi.controller;

import com.aiit.webapi.model.dto.LoginDTO;
import com.aiit.webapi.model.dto.PageDTO;
import com.aiit.webapi.model.dto.UserPageDTO;
import com.aiit.webapi.model.entity.User;
import com.aiit.webapi.model.vo.UserInfoVo;
import com.aiit.webapi.service.intf.UserService;
import com.aiit.webapi.utils.Response;
import com.aiit.webapi.model.vo.UserVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xinghengpo
 */
@Api(tags = "用户相关api")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 分页查询用户列表
     * @param pageDTO
     * @return
     */
    @ApiOperation(value = "分页查询用户列表", notes = "分页查询用户列表")
    @PostMapping("/list")
    public Response<PageInfo<UserInfoVo>> findAll(@RequestBody UserPageDTO pageDTO) {
        PageInfo<UserInfoVo> userList = userService.findAll(pageDTO);
        return Response.success(userList);
    }

    @ApiOperation(value = "根据id获得用户信息", notes = "根据id获得用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @GetMapping("/{id}")
    public Response<User> findUserById(@PathVariable("id") Integer id) {
        return Response.success(userService.findUserById(id));
    }

    @ApiOperation(value = "新增或更新用户", notes = "新增或更新用户")
    @ApiImplicitParam(name = "user", value = "User的对象", required = true, dataType = "User")
    @PostMapping("/addOrUpdate")
    public Response addOrUpdate(@RequestBody User user) {
        UserVo userVo = new UserVo();
        // 如果不存在，则是新增，返回新增的主键
        if(!ObjectUtils.isEmpty(user.getId())) {
            boolean isUpdate = userService.updateUser(user);
            userVo.setUpdate(isUpdate);
            userVo.setUserId(user.getId());
        } else {
            String addId = userService.addUser(user);
            if(addId == "not uniq") {
                return Response.success("account重复");
            }
            userVo.setUserId(addId);
        }
        return Response.success(userVo);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "userId", value = "用户的id", required = true, dataType = "int")
    @DeleteMapping("/delete/{userId}")
    public Response<Boolean> deleteUserById(@PathVariable("userId") Integer id) {
        boolean isOk = userService.deleteUserById(id);
        return isOk ? Response.success(true) : Response.error(500, "删除失败");
    }

    @PostMapping("/login")
    public Response<Boolean> login(@RequestBody LoginDTO user) {
        boolean isOk = userService.login(user);
        return isOk ? Response.success(true) : Response.error(200, "登录失败", false);
    }
}
