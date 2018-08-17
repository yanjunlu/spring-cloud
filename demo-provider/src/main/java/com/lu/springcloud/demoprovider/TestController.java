package com.lu.springcloud.demoprovider;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${com.lu.key1}")
    private String value1;
    @Value("${com.lu.key2}")
    private String value2;

    @Autowired
    private Tracer tracer;

    @RequestMapping("/hello")
    String hello() {

        logger.info("traceId:{}", tracer.currentSpan().context().traceIdString());
        logger.info("traceId/spanId:{}", tracer.currentSpan().toString());
        return "hello:" + value1 + " " + value2;
    }

    @RequestMapping("/ack")
    String ack() {

        return "ack";
    }
}
