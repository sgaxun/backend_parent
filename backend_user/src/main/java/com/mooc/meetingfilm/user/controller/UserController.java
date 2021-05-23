package com.mooc.meetingfilm.user.controller;

import com.mooc.meetingfilm.user.controller.vo.LoginReqVo;
import com.mooc.meetingfilm.user.service.UserServiceAPI;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.properties.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sgaxun
 * @date Created in 2021/5/20 22:28
 * @description 用户模块表现层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceAPI userServiceAPI;

    @PostMapping("/login")
    public BaseResponseVO login(@RequestBody LoginReqVo reqVo) throws CommonServiceException {

        //数据验证
        reqVo.checkParam();
        //验证用户名和密码是否正确
        String userId = userServiceAPI.checkUserLogin(reqVo.getUsername(), reqVo.getPassword());

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomkey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomkey);

        Map<String, String> result = new HashMap<>();
        result.put("randomKey", randomkey);
        result.put("token", token);

        return BaseResponseVO.success(result);
    }
}
