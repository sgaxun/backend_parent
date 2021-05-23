package com.mooc.meetingfilm.user.service;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @author sgaxun
 * @date Created in 2021/5/21 21:04
 * @description 用户接口
 */
public interface UserServiceAPI {

    String checkUserLogin(String username, String password) throws CommonServiceException;
}
