package com.geo.coupon.calculation.template.impl;

import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.template.AbstractRuleTemplate;
import com.geo.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 无优惠券 空实现
 * @author geooo
 * @date 2022/8/21 12:03
 */
@Slf4j
@Component
public class EmptyTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        long allCost = getTotalPrice(order.getProducts());
        order.setCost(allCost);
        return order;
    }
}
