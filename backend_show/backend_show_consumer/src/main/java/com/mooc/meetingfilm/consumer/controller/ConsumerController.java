package com.mooc.meetingfilm.consumer.controller;

import com.mooc.meetingfilm.consumer.service.ConsumerServiceAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sgaxun
 * @date Created in 2021/5/22 16:12
 * @description TODO
 */
@RestController
public class ConsumerController {

    @Resource
    private ConsumerServiceAPI serviceAPI;

    @RequestMapping("/sayHello")
    public String sayHello(String message){

        return serviceAPI.sayHello(message);
    }
}
