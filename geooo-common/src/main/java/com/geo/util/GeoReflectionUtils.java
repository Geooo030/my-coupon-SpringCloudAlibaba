package com.geo.util;

import lombok.extern.slf4j.Slf4j;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author Geooo
 * @date 2022/8/25 22:53
 */
@Slf4j
public class GeoReflectionUtils extends ReflectionUtils {

    static Reflections reflections = null;

    static {
        String[] basePackages = SpringContextHolder.getBasePackages();
        log.debug("Scan base package {}",basePackages);
        reflections = new Reflections(basePackages);
    }

    public static <T> Set<Class<? extends T>> getSubClassOf (Class<T> clazz) {
        return reflections.getSubTypesOf(clazz);
    }
}
