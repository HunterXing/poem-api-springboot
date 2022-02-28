package com.aiit.webapi.service.impl;

import com.aiit.webapi.mapper.PoemMapper;
import com.aiit.webapi.model.dto.PoemDTO;
import com.aiit.webapi.model.entity.Poem;
import com.aiit.webapi.model.vo.CountVo;
import com.aiit.webapi.service.intf.PoemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xingheng
 */
@Service
public class PoemServiceImpl implements PoemService {
    @Resource
    private PoemMapper poemMapper;
    @Override
    public PageInfo<Poem> findPoem(PoemDTO poem) {
        PageHelper.startPage(poem.getPageIndex(), poem.getPageSize());
        List<Poem> list = poemMapper.findPoem(poem);
        PageInfo<Poem> poemInfo = new PageInfo<>(list);
        return poemInfo;
    }

    /**
     * 查询诗词的分类数量
     * @return
     */
    @Override
    public List<CountVo> count() {
        return poemMapper.count();
    }
}
