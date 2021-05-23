package com.mooc.meetingfilm.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sgaxun
 * @date Created in 2021/5/22 16:07
 * @description TODO
 */
@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private int port;

    @RequestMapping(value = "/provider/sayhello")
    public String providerSayHello(String message){

        log.error("provider sayHello port:{}, message{}", port, message);
        return "Provider sayHello port:" + port + ", message:" + message;
    }
}
