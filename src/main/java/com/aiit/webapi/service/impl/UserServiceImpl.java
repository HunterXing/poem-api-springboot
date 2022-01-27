package com.aiit.webapi.service.impl;

import com.aiit.webapi.model.entity.User;
import com.aiit.webapi.mapper.UserMapper;
import com.aiit.webapi.service.intf.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findUsers(Integer pageIndex, Integer pageSize) {
        List<User> list = userMapper.findUsers((pageIndex - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public PageInfo<User> findAll(Integer pageIndex, Integer pageSize) {
        // 分页
        PageHelper.startPage(pageIndex,pageSize);
        //查询分组列表
        List<User> list = userMapper.findAll();
        // 获取分页信息
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int addUser(User user) {
        // mapper返回的数值总会是影响数,真正的id是mybatis 封装在insertMode中, 需要insertMode.getId()获取
        userMapper.addUser(user);
        // insertMode.getId()获取新增的主键
        int userId = user.getId();
        return userId;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        boolean isOk = userMapper.deleteUserById(id);
        return isOk;
    }
}
