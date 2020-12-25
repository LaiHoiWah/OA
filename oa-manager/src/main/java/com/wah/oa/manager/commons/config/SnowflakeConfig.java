package com.wah.oa.manager.commons.config;

import com.wah.commons.utils.SnowFlakeUtils;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "snowflake")
@Setter
public class SnowflakeConfig{

    private Long centerId;
    private Long workerId;

    @Bean
    public SnowFlakeUtils snowFlakeUtils(){
        return new SnowFlakeUtils(centerId, workerId);
    }
}
