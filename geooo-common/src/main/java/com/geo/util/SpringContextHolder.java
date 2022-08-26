package com.geo.util;

import lombok.experimental.UtilityClass;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Geooo
 * @date 2022/8/25 23:00
 */
@UtilityClass
public class SpringContextHolder {
    static ApplicationContext applicationContext;

    static String[] basePackages;

    public String[] getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String[] packages) {
        basePackages = packages;
    }


    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;

    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取class对应的bean
     *
     * @param <T> 类型
     * @return bean
     */
    public <T> T getBean(Class<T> requiredType) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(requiredType);
    }
}
