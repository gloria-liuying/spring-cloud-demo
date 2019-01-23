package com.resoft.register;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/8
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RegisterApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class,args);
    }
}
