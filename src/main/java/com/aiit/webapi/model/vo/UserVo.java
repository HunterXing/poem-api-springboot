package com.aiit.webapi.model.vo;

import lombok.Data;

/**
 * @author xingheng
 */
@Data
public class UserVo {
    /**
     * 插入对象成功返回的id
     */
    private int userId;
    /**
     * 操作是否更新成功
     */
    private boolean isUpdate;
}
