package com.mooc.meetingfilm.utils.common.vo;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/23 16:50
 * @description 分页请求类
 */
@Data
public class BasePageVo extends BaseRequestVO{

    private Integer nowPage = 1;

    private Integer pageSize = 10;

    @Override
    public void checkParam() throws CommonServiceException {

        if (nowPage == null || nowPage == 0){
            throw new CommonServiceException(404, "nowPage不能为空");
        } else if (pageSize == null || pageSize ==0){
            throw new CommonServiceException(404, "pageSize不能为空");
        }
    }
}
