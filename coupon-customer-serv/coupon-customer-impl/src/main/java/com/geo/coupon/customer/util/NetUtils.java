package com.geo.coupon.customer.util;

import com.geo.coupon.template.api.beans.CouponTemplateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Geooo
 * @date 2022/8/23 23:22
 */
@Component
public class NetUtils {

    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * webClient请求get方法
     * @param path 请求路径 serv + path
     * @param param 参数
     * @param clzz 返回类型class
     * @param <V> 返回类型（泛型）
     * @return 接口返回值
     */
    public <V> V getRequestPath(String path, String param,Class<V> clzz) {
        return webClientBuilder.build()
                .get()
                .uri("http://"+ path + "?" + param)
                .retrieve()
                .bodyToMono(clzz)
                .block();
    }

    public <V, K> V postRequestPath(String path, Object paramBody, Class<K> bodyClazz, Class<V> clazz) {
        return webClientBuilder.build()
                .post()
                .uri(path)
                .body(paramBody, bodyClazz)
                .retrieve()
                .bodyToMono(clazz)
                .block();
    }
}
