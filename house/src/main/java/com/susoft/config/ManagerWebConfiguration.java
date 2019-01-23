package com.susoft.config;

import com.susoft.cache.RedisConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/23
 */
@Configuration
@EnableAutoConfiguration
@Import({RedisConfig.class,WebSecurityModuleConfiguration.class})
public class ManagerWebConfiguration {
}
