package com.susoft;

import com.susoft.config.ManagerWebConfiguration;
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
 * @since 2019/1/16
 */
@EnableEurekaClient
@SpringBootApplication
public class HouseApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HouseApplication.class);
    }

    public static void main(String[] args) {
//        SpringApplication.run(HouseApplication.class,args);
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication app = new SpringApplication(ManagerWebConfiguration.class);
        app.run(args);
    }

}
