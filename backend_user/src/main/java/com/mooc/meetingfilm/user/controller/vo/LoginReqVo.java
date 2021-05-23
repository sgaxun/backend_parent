package com.mooc.meetingfilm.user.controller.vo;

import com.mooc.meetingfilm.utils.common.vo.BaseRequestVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.ToolUtils;
import lombok.Data;

/**
 * @author sgaxun
 * @date Created in 2021/5/20 22:30
 * @description 登陆请求对象
 */
@Data
public class LoginReqVo extends BaseRequestVO {

    private String username;
    private String password;


    @Override
    public void checkParam() throws CommonServiceException {
        if (ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)){
            throw new CommonServiceException(404, "username or password must be required!");
        }
    }
}
