package com.aiit.webapi.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.aiit.webapi.model.dto.LoginDTO;
import com.aiit.webapi.model.dto.UserPageDTO;
import com.aiit.webapi.model.entity.User;
import com.aiit.webapi.mapper.UserMapper;
import com.aiit.webapi.model.vo.UserInfoVo;
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
    public PageInfo<UserInfoVo> findAll(UserPageDTO user) {
        // 分页
        PageHelper.startPage(user.getPageIndex(),user.getPageSize());
        //查询分组列表
        List<UserInfoVo> list = userMapper.findAll(user);
        // 获取分页信息
        PageInfo<UserInfoVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public String addUser(User user) {
        if(isUniqAccount(user)) {
            // mapper返回的数值总会是影响数,真正的id是mybatis 封装在insertMode中, 需要insertMode.getId()获取
            user.setId(IdUtil.simpleUUID());
            String md5Password = SecureUtil.md5(user.getPassword()+user.getAccount());
            user.setPassword(md5Password);
            userMapper.addUser(user);
            // insertMode.getId()获取新增的主键
            String userId = user.getId();
            return userId;
        } else {
            return "not uniq";
        }
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

    @Override
    public boolean login(LoginDTO user) {
        String md5Password = SecureUtil.md5(user.getPassword()+user.getUsername());
        user.setPassword(md5Password);
        boolean isOk = userMapper.login(user) > 0;
        return isOk;
    }

    @Override
    public Boolean isUniqAccount(User user) {
        return userMapper.accountNum(user) < 1;
    }
}
