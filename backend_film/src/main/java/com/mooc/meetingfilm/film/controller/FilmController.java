package com.mooc.meetingfilm.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.film.service.FilmServiceAPI;
import com.mooc.meetingfilm.utils.common.vo.BasePageVo;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 16:47
 * @description 影片表现层
 */
@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmServiceAPI filmServiceAPI;

    /**
     * 获取演员列表
     * @param basePageVo
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("/actors")
    public BaseResponseVO describeActors(BasePageVo basePageVo) throws CommonServiceException {
        //检查入参
        basePageVo.checkParam();

        IPage<DescribeActorsRespVO> results = filmServiceAPI.describeActors(basePageVo.getNowPage(), basePageVo.getPageSize());

        Map<String, Object> actors = describePageResult(results, "actors");

        return BaseResponseVO.success(actors);
    }

    /**
     * 获取影片列表
     * @param basePageVo
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("")
    public BaseResponseVO describeFilms(BasePageVo basePageVo) throws CommonServiceException {
        //检查入参
        basePageVo.checkParam();

        IPage<DescribeFilmsRespVO> results = filmServiceAPI.describeFilms(basePageVo.getNowPage(), basePageVo.getPageSize());

        Map<String, Object> films = describePageResult(results, "films");

        return BaseResponseVO.success(films);
    }

    /**
     * 根据电影主键获取电影信息
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    @GetMapping("/{filmId}")
    public BaseResponseVO describeFilmById(@PathVariable("filmId")String filmId) throws CommonServiceException {

        DescribeFilmRespVO describeFilmRespVO = filmServiceAPI.describeFilmById(filmId);
        if (describeFilmRespVO == null){
            return BaseResponseVO.success();
        } else {
            return BaseResponseVO.success(describeFilmRespVO);
        }
    }


    @PostMapping("/film:add")
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) throws CommonServiceException {

        filmServiceAPI.saveFilm(filmSavedReqVO);

        return BaseResponseVO.success();
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
