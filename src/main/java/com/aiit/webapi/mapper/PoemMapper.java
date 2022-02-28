package com.aiit.webapi.mapper;

import com.aiit.webapi.model.dto.PoemDTO;
import com.aiit.webapi.model.entity.Poem;
import com.aiit.webapi.model.vo.CountVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xingheng
 * 指定这是一个操作数据库的mapper
 */
@Mapper
public interface PoemMapper {
    /**
     * 查找用户 通过分页插件
     * @param poem
     * @return
     */
    List<Poem> findPoem(PoemDTO poem);

    /**
     *  查询诗词的分类数量
     * @return
     */
    List<CountVo> count();
}
