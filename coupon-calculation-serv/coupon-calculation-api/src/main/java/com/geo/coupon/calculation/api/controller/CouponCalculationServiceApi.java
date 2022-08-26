package com.geo.coupon.calculation.api.controller;

import com.geo.annotation.GeoFeignClient;
import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Geooo
 * @date 2022/8/21 19:13
 */

@GeoFeignClient(name = "coupon-calculation-serv")
@RequestMapping("/calculator")
public interface CouponCalculationServiceApi {

    // 优惠券结算
    @PostMapping(value = "/checkout")
    ShoppingCart calculateOrderPrice(ShoppingCart settlement);

    // 优惠券列表挨个试算
    // 给客户提示每个可用券的优惠额度，帮助挑选
    @PostMapping(value = "/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}
