package com.susoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/28
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GatewayApplication.class);
    }

    public static void main(String[] args) {
            SpringApplication.run(GatewayApplication.class, args);
    }
}
