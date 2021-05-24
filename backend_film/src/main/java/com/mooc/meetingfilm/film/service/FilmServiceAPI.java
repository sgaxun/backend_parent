package com.mooc.meetingfilm.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 17:07
 * @description 影片逻辑层
 */
public interface FilmServiceAPI {

    /**
     * 获取演员列表
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException;

    /**
     * 获取影片列表
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException;

    /**
     * 根据filmId获取影片信息
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    DescribeFilmRespVO describeFilmById(String filmId) throws CommonServiceException;

    /**
     * 新增影片
     * @param filmSavedReqVO
     * @throws CommonServiceException
     */
    void saveFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException;
}
