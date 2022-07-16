package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.dto.UserPageDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xingheng
 */
public interface UserService extends IService {
    /**
     * @param user
     * @description TableId 注解存在更新记录，否插入一条记录
     * @return
     */
    boolean saveOrUpdate(UserPageDTO user);
}
