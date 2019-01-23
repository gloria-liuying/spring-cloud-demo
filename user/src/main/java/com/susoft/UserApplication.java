package com.susoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/8
 */
@EnableEurekaClient
@SpringBootApplication
public class UserApplication //extends SpringBootServletInitializer
 {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(UserApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
