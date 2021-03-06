package com.mooc.meetingfilm.film.controller.vo;

import com.mooc.meetingfilm.utils.common.vo.BaseRequestVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * class
 *
 * @author sgaxun
 * @date 2019-12-27 12:38
 */
@Data
public class FilmSavedReqVO extends BaseRequestVO {

    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;


    @Override
    public void checkParam() throws CommonServiceException {

    }
}
