package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/19 20:47
 * @description TODO
 */
@Data
public class BaseResponseVO<T> {

    private Integer code;
    private String message;
    private T data;

    private BaseResponseVO(){}

    /**
     * 成功无参数
     * @return
     */
    public static BaseResponseVO success(){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        return response;
    }

    /**
     * 成功有参数
     * @param data
     * @param <T>
     * @return
     */
    public static<T> BaseResponseVO success(T data){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        response.setData(data);
        return response;
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    public static BaseResponseVO serviceException(CommonServiceException e){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }
}
