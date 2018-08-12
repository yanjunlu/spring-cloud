package com.lu.springcloud.democonsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luyanjun
 * 2018/8/12
 **/
@RestController
public class CallTestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/callhello")
    public String callHello() {
        String result = restTemplate.getForObject("http://demo-provider/hello", String.class);
        return result;
    }
}
