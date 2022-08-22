package com.geo.coupon.calculation.controller;

import com.alibaba.fastjson.JSON;
import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import com.geo.coupon.calculation.api.controller.CouponCalculationServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.geo.coupon.calculation.service.CouponCalculationService;

/**
 * @author Geooo
 * @date 2022/8/21 19:17
 */
@Slf4j
@RestController
public class CouponCalculationController implements CouponCalculationServiceApi {

    @Autowired
    private CouponCalculationService couponCalculationService;

    @Override
    public ShoppingCart calculateOrderPrice(@Validated @RequestBody ShoppingCart settlement) {
        log.info("do calculation: {}", JSON.toJSONString(settlement));
        return couponCalculationService.calculateOrderPrice(settlement);
    }

    @Override
    public SimulationResponse simulate(@RequestBody SimulationOrder simulator) {
        log.info("do simulation: {}", JSON.toJSONString(simulator));

        return couponCalculationService.simulateOrder(simulator);
    }
}
