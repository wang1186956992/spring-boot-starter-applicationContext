package com.learn.application.context.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yf003 on 2017/9/12.
 */
@Configuration
public class AutoApplicationConfig {

    @Bean
    public ApplicationUtil app(@Autowired ApplicationContext applicationContext) {
        return ApplicationUtil.init(applicationContext);
    }


}
