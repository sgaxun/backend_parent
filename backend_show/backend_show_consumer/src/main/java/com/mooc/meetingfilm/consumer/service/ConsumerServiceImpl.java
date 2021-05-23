package com.mooc.meetingfilm.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sgaxun
 * @date Created in 2021/5/22 16:11
 * @description TODO
 */
@Service
public class ConsumerServiceImpl implements ConsumerServiceAPI{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient eurekaClient;

    @Override
    public String sayHello(String message) {
//        String hostName = "localhost";
//        int port = 7101;
//        String uri = "/provider/sayhello?message=" + message;

        //get register
        ServiceInstance instance = eurekaClient.choose("eureka-provider");
        String hostName = instance.getHost();
        int port = instance.getPort();
        String uri = "/provider/sayhello?message=" + message;

        String url = "http://" + hostName +":" + port +uri;
        // invoker provider test
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
