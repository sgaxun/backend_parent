package com.mooc.meetingfilm.utils.exception;

import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/20 22:36
 * @description 公共的业务逻辑错误
 */
@Data
public class CommonServiceException extends Exception{

    private Integer code;
    private String message;

    public CommonServiceException(int code, String message){
        this.code = code;
        this.message = message;
    }
}
