package com.geo.coupon.calculation.service.impl;

import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import com.geo.coupon.template.api.beans.CouponInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geo.coupon.calculation.service.CouponCalculationService;
import com.geo.coupon.calculation.template.RuleTemplate;
import com.geo.coupon.calculation.template.RuleTemplateFactory;

/**
 * @author Geooo
 * @date 2022/8/21 19:22
 */
@Slf4j
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {

    @Autowired
    private RuleTemplateFactory ruleTemplateFactory;

    // 优惠券结算
    // 这里通过Factory类决定使用哪个底层Rule，底层规则对上层透明
    @Override
    public ShoppingCart calculateOrderPrice(ShoppingCart cart) {
        RuleTemplate template = ruleTemplateFactory.getTemplate(cart);
        return template.calculate(cart);
    }

    // 对所有优惠券进行试算，看哪个最赚钱
    @Override
    public SimulationResponse simulateOrder(SimulationOrder order) {
        SimulationResponse res = new SimulationResponse();
        Long minOrderPrice = Long.MAX_VALUE;

        for (CouponInfo couponInfo : order.getCouponInfos()) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setCouponInfos(Lists.newArrayList(couponInfo));
            shoppingCart.setProducts(order.getProducts());
            ruleTemplateFactory.getTemplate(shoppingCart).calculate(shoppingCart);

            Long couponId = couponInfo.getId();
            Long cost = shoppingCart.getCost();
            res.getCouponToOrderPrice().put(couponId, cost);

            if (minOrderPrice > cost) {
                res.setBestCouponId(couponId);
                minOrderPrice = cost;
            }

        }

        return res;
    }
}
