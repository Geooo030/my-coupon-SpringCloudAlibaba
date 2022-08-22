package com.geo.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

/**
 * @author geooo
 * @date 2022/8/20 21:37
 */

// 订单试算结果，可以看出哪个优惠券的优惠力度最大
@Data
@NoArgsConstructor
public class SimulationResponse {
    // 最省钱的coupon
    private Long bestCouponId;
    // 每一个coupon对应的order价格
    private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();

}

