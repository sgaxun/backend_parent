package com.mooc.meetingfilm.film.service;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmActorT;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmInfoT;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmT;
import com.mooc.meetingfilm.film.dao.mapper.MoocActorTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmActorTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmInfoTMapper;
import com.mooc.meetingfilm.film.dao.mapper.MoocFilmTMapper;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.ToolUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 17:07
 * @description 影片模块实现层
 */
@Service
public class FilmServiceImpl implements FilmServiceAPI{

    @Resource
    private MoocActorTMapper actorTMapper;

    @Resource
    private MoocFilmTMapper filmTMapper;

    @Resource
    private MoocFilmInfoTMapper filmInfoTMapper;

    @Resource
    private MoocFilmActorTMapper filmActorTMapper;

    /**
     * 演员列表查询
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    @Override
    public IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException {

        return actorTMapper.describeActors(new Page<>(nowPage, pageSize));
    }

    /**
     * 影片查询列表
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    @Override
    public IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException {
        return filmTMapper.describeFilms(new Page<>(nowPage, pageSize));
    }

    /**
     * 根据id查询影片信息
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    @Override
    public DescribeFilmRespVO describeFilmById(String filmId) throws CommonServiceException {
        return filmTMapper.describeFilmById(filmId);
    }

    /**
     * 保存电影信息
     * @param reqVO
     * @throws CommonServiceException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFilm(FilmSavedReqVO reqVO) throws CommonServiceException {
        try {
            // 保存电影主表
            MoocFilmT film = new MoocFilmT();
            film.setFilmName(reqVO.getFilmName());
            film.setFilmType(ToolUtils.str2Int(reqVO.getFilmTypeId()));
            film.setImgAddress(reqVO.getMainImgAddress());
            film.setFilmScore(reqVO.getFilmScore());
            film.setFilmPresalenum(ToolUtils.str2Int(reqVO.getPreSaleNum()));
            film.setFilmBoxOffice(ToolUtils.str2Int(reqVO.getBoxOffice()));
            film.setFilmSource(ToolUtils.str2Int(reqVO.getFilmSourceId()));
            film.setFilmCats(reqVO.getFilmCatIds());
            film.setFilmArea(ToolUtils.str2Int(reqVO.getAreaId()));
            film.setFilmDate(ToolUtils.str2Int(reqVO.getDateId()));
            film.setFilmTime(ToolUtils.str2LocalDateTime(reqVO.getFilmTime() + " 00:00:00"));
            film.setFilmStatus(ToolUtils.str2Int(reqVO.getFilmStatus()));


            filmTMapper.insert(film);
            // 保存电影子表
            MoocFilmInfoT filmInfoT = new MoocFilmInfoT();
            filmInfoT.setFilmId(film.getUuid());
            filmInfoT.setFilmEnName(reqVO.getFilmEnName());
            filmInfoT.setFilmScore(reqVO.getFilmScore());
            filmInfoT.setFilmScoreNum(ToolUtils.str2Int(reqVO.getFilmScorers()));
            filmInfoT.setFilmLength(ToolUtils.str2Int(reqVO.getFilmLength()));
            filmInfoT.setBiography(reqVO.getBiography());
            filmInfoT.setDirectorId(ToolUtils.str2Int(reqVO.getDirectorId()));
            filmInfoT.setFilmImgs(reqVO.getFilmImgs());

            filmInfoTMapper.insert(filmInfoT);

            String[] actorId = reqVO.getActIds().split("#");
            String[] roleNames = reqVO.getRoleNames().split("#");
            if (actorId.length != roleNames.length){
                throw new CommonServiceException(500, "演员和角色名数量不匹配");
            }

            for (int i = 0; i < actorId.length; i++){
                // 保存演员映射
                MoocFilmActorT filmActorT = new MoocFilmActorT();
                filmActorT.setFilmId(film.getUuid());
                filmActorT.setActorId(ToolUtils.str2Int(actorId[i]));
                filmActorT.setRoleName(roleNames[i]);

                filmActorTMapper.insert(filmActorT);
            }
        } catch (Exception e){
            throw new CommonServiceException(500, e.getMessage());
        }
    }
}
