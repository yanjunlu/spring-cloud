package com.lu.springcloud.demoprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProviderApplication {


    public static void main(String[] args) {

        SpringApplication.run(DemoProviderApplication.class, args);
    }
}
