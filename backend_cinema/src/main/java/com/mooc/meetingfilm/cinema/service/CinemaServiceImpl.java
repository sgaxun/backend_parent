package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.cinema.dao.entity.MoocCinemaT;
import com.mooc.meetingfilm.cinema.dao.mapper.MoocCinemaTMapper;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.ToolUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sgaxun
 * @date Created in 2021/5/25 22:19
 * @description TODO
 */
@Service
public class CinemaServiceImpl implements CinemaServiceAPI{

    @Resource
    private MoocCinemaTMapper cinemaTMapper;

    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {
        MoocCinemaT cinemaT = new MoocCinemaT();
        cinemaT.setCinemaName(reqVO.getCinemaName());
        cinemaT.setCinemaPhone(reqVO.getCinemaTele());
        cinemaT.setBrandId(ToolUtils.str2Int(reqVO.getBrandId()));
        cinemaT.setAreaId(ToolUtils.str2Int(reqVO.getAreaId()));
        cinemaT.setHallIds(reqVO.getHallTypeIds());
        cinemaT.setImgAddress(reqVO.getCinemaImgAddress());
        cinemaT.setCinemaAddress(reqVO.getCinemaAddress());
        cinemaT.setMinimumPrice(ToolUtils.str2Int(reqVO.getCinemaPrice()));

        this.cinemaTMapper.insert(cinemaT);
    }

    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(int nowPage, int pageSize) throws CommonServiceException {

        //查询实体对象与表现对象进行交互
        Page<MoocCinemaT> page = new Page<>(nowPage, pageSize);
        IPage<MoocCinemaT> data = this.cinemaTMapper.selectPage(page, null);

        IPage<DescribeCinemasRespVO> iPage = new Page<>();
        iPage.setPages(data.getPages());
        iPage.setTotal(data.getTotal());
        iPage.setSize(data.getSize());
        iPage.setCurrent(data.getCurrent());
        List<DescribeCinemasRespVO> cinemasRespVOS = new ArrayList<>();
        data.getRecords().stream().forEach(record ->{
            DescribeCinemasRespVO describeCinemasRespVO = new DescribeCinemasRespVO();
            describeCinemasRespVO.setBrandId(String.valueOf(record.getBrandId()));
            describeCinemasRespVO.setAreaId(String.valueOf(record.getAreaId()));
            describeCinemasRespVO.setHallTypeIds(record.getHallIds());
            describeCinemasRespVO.setCinemaName(record.getCinemaName());
            describeCinemasRespVO.setCinemaAddress(record.getCinemaAddress());
            describeCinemasRespVO.setCinemaTele(record.getCinemaPhone());
            describeCinemasRespVO.setCinemaImgAddress(record.getImgAddress());
            describeCinemasRespVO.setCinemaPrice(String.valueOf(record.getMinimumPrice()));
            cinemasRespVOS.add(describeCinemasRespVO);
        });
        iPage.setRecords(cinemasRespVOS);
        return iPage;
    }
}
