package com.geo.config;
import com.geo.util.GeoReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.*;
import org.springframework.stereotype.Controller;

import java.util.Objects;
import java.util.Set;


/**
 * @author Geooo
 * @date 2022/8/24 23:26
 */
@Slf4j
public class GeoFeignCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ClassMetadata classMetaData = (ClassMetadata) metadata;
        String className = classMetaData.getClassName();
        Class interfaceClass = null;
        try {
            interfaceClass = Class.forName(className);
        } catch (ClassNotFoundException e) {};

        Set<Class<?>> subClasses = GeoReflectionUtils.getSubClassOf(interfaceClass);
        for (Class implClass : subClasses) {
            Controller annotation = AnnotationUtils.findAnnotation(implClass, Controller.class);
            // 有被 @Controller 注解修饰的类 实现了@GeoFeignClient的Api
            // 证明是该服务自己实现了Api就不用 @FeignClient 实现动态代理了，否则会报错
            if (Objects.nonNull(annotation)) {
                log.debug("{} exits Controller.class ,no init feign {}", implClass.getName(), interfaceClass.getName());
                return ConditionOutcome.noMatch(implClass.getName() + " exits implement!");
            }
        }
        return ConditionOutcome.match();
    }
}
