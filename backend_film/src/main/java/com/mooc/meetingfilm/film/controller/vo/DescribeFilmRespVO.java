package com.mooc.meetingfilm.film.controller.vo;

import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 20:21
 * @description 根据主键获取影片信息对象
 */
@Data
public class DescribeFilmRespVO {

    private String filmId;

    private String filmName;

    private String filmLength;

    private String filmCats;

    private String actors;

    private String imgAddress;

    private String subAddress;
}
