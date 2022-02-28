package com.aiit.webapi.service.intf;

import com.aiit.webapi.model.dto.PoemDTO;
import com.aiit.webapi.model.entity.Poem;
import com.aiit.webapi.model.vo.CountVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xingheng
 */
public interface PoemService {
    /**
     * 查询所有组织
     * @param poem
     * @return
     */
    PageInfo<Poem> findPoem(PoemDTO poem);

    /**
     * 查询诗词的分类数量
     * @return
     */
    List<CountVo> count();
}
