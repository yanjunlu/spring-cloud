package com.lu.springcloud.demoprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyanjun
 * 2018/8/11 22:46
 **/
@RestController
@PropertySource("${com.lu.properties.location}:test.properties")
public class TestController {
    @Value("${com.lu.key1}")
    private String value1;
    @Value("${com.lu.key2}")
    private String value2;

    @RequestMapping("/hello")
    String hello() {
        return "hello:" + value1 + " " + value2;
    }
}
