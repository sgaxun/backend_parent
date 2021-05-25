package com.mooc.meetingfilm.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.cinema.service.CinemaServiceAPI;
import com.mooc.meetingfilm.utils.common.vo.BasePageVo;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author sgaxun
 * @date Created in 2021/5/25 21:29
 * @description TODO
 */
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Resource
    private CinemaServiceAPI cinemaServiceAPI;

    @PostMapping("/cinema:add")
    public BaseResponseVO saveCinema(@RequestBody CinemaSavedReqVO reqVO) throws CommonServiceException {
        //验证
        reqVO.checkParam();

        cinemaServiceAPI.saveCinema(reqVO);

        return BaseResponseVO.success();
    }

    @GetMapping("/")
    public BaseResponseVO describeCinemas(BasePageVo basePageVo) throws CommonServiceException{

        IPage<DescribeCinemasRespVO> iPage = cinemaServiceAPI.describeCinemas(basePageVo.getNowPage(), basePageVo.getPageSize());

        // TODO 调用封装分页返回
        Map<String, Object> result = describePageResult(iPage, "cinemas");

        return BaseResponseVO.success(result);
    }


    /**
     * 封装返回信息
     * @param page
     * @param title
     * @return
     */
    private Map<String, Object> describePageResult(IPage page, String title){
        Map<String, Object> result = Maps.newHashMap();
        result.put("totalSize", page.getTotal());
        result.put("totalPages", page.getPages());
        result.put("pageSize", page.getSize());
        result.put("nowPage", page.getCurrent());

        result.put(title, page.getRecords());

        return result;
    }
}
