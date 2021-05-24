package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 17:11
 * @description 影片信息VO
 */
@Data
public class DescribeFilmsRespVO {

    private String filmId;

    private String filmStatus;

    private String filmName;

    private String filmEnName;

    private String filmScore;

    private String preSaleNum;

    private String boxOffice;

    private String filmTime;

    private String filmLength;

    private String mainImg;
}
