package com.geo.annotation;

import com.geo.config.GeoFeignCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author Geooo
 * @date 2022/8/24 23:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@FeignClient
@Conditional(GeoFeignCondition.class)
public @interface GeoFeignClient {

    @AliasFor(annotation = FeignClient.class)
    String value() default "";

    String contextId() default "";

    @AliasFor(annotation = FeignClient.class)
    String name() default "";


    @AliasFor(annotation = FeignClient.class)
    Class<?> fallback() default void.class;

    @AliasFor(annotation = FeignClient.class)
    Class<?> fallbackFactory() default void.class;

}
