package com.mooc.meetingfilm.cinema.controller.vo;

import com.mooc.meetingfilm.utils.common.vo.BaseRequestVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/25 22:08
 * @description TODO
 */
@Data
public class CinemaSavedReqVO extends BaseRequestVO {

    private String brandId;

    private String areaId;

    private String hallTypeIds;

    private String cinemaName;

    private String cinemaAddress;

    private String cinemaTele;

    private String cinemaImgAddress;

    private String cinemaPrice;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
