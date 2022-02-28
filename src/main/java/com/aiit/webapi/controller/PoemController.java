package com.aiit.webapi.controller;

import com.aiit.webapi.model.dto.PoemDTO;
import com.aiit.webapi.model.dto.UserPageDTO;
import com.aiit.webapi.model.entity.Poem;
import com.aiit.webapi.model.vo.CountVo;
import com.aiit.webapi.model.vo.UserInfoVo;
import com.aiit.webapi.service.intf.PoemService;
import com.aiit.webapi.utils.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 诗词类控制器
 * @author xingheng
 */
@CrossOrigin
@RestController
@RequestMapping("/poem")
public class PoemController {
    @Resource
    private PoemService poemService;

    @ApiOperation(value = "诗词列表", notes = "诗词列表")
    @PostMapping("/list")
    public Response<PageInfo<Poem>> findPoem(@RequestBody PoemDTO pageDTO) {
        PageInfo<Poem> poemList = poemService.findPoem(pageDTO);
        return Response.success(poemList);
    }

    @GetMapping("/count")
    public Response<List<CountVo>> count() {
        List<CountVo> countList = poemService.count();
        return Response.success(countList);
    }
}
