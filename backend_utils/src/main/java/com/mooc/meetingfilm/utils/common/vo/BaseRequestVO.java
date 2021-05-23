package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @author sgaxun
 * @date Created in 2021/5/20 22:33
 * @description TODO
 */
public abstract class BaseRequestVO {

    /**
     * @Description: 公共基础验证
     * @Author: sgaxun
     */
    public abstract void checkParam() throws CommonServiceException;
}
