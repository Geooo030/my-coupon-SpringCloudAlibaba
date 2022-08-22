package com.geo.coupon.calculation.api.controller;

import com.alibaba.fastjson.JSON;
import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Geooo
 * @date 2022/8/21 19:13
 */
@RequestMapping("/calculator")
public interface CouponCalculationServiceApi {

    // 优惠券结算
    @PostMapping("/checkout")
    ShoppingCart calculateOrderPrice(ShoppingCart settlement);

    // 优惠券列表挨个试算
    // 给客户提示每个可用券的优惠额度，帮助挑选
    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}
