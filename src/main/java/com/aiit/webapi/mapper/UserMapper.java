package com.aiit.webapi.mapper;

import com.aiit.webapi.model.dto.UserPageDTO;
import com.aiit.webapi.model.entity.User;
import com.aiit.webapi.model.vo.UserInfoVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xingheng
 * 指定这是一个操作数据库的mapper
 */
@Mapper
public interface UserMapper {
    /**
     * 查找用户 通过分页插件
     * @return
     */
    List<UserInfoVo> findAll(@Param("userInfo") UserPageDTO userInfo);
    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_user where id = #{id}")
    User findUserById(@Param("id") int id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(@Param("user") User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Boolean updateUser(@Param("user") User user);

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Delete("DELETE from tb_user where id = #{id}")
    Boolean deleteUserById(@Param("id") int id);

}
