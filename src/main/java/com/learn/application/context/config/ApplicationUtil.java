package com.learn.application.context.config;

import org.springframework.context.ApplicationContext;

/**
 * Created by yf003 on 2017/9/12.
 */
public class ApplicationUtil {
    protected static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static ApplicationUtil init(ApplicationContext app) {
        setApplicationContext(app);
        return new ApplicationUtil();
    }
}
