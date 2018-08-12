package com.lu.springcloud.democonsumer;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(CallTestController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Tracer tracer;

    @RequestMapping("/callhello")
    public String callHello() {
        String result = restTemplate.getForObject("http://demo-provider/hello", String.class);
        logger.info("traceId:{}", tracer.currentSpan().context().traceIdString());
        logger.info("traceId/spanId:{}", tracer.currentSpan().toString());
        return result;
    }
}
