package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xingheng
 */
public interface UserService {
    /**
     * 返回用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<User> findUsers(Integer pageIndex, Integer pageSize);

    /**
     * 通过分页插件查询用户列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<User> findAll(Integer pageIndex, Integer pageSize);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    Boolean deleteUserById(Integer id);
}