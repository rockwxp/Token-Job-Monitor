package com.tensai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rock
 * @date 1/27/22 11:14 PM
 * @description TODO
 */
@Configuration
public class SysConfig {

    @Bean("config_test")
    public String getConfig(){
        return "config1";
    }
}
