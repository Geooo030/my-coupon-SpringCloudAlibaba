package com.geo.coupon.calculation.template.impl;

import com.geo.coupon.calculation.template.AbstractRuleTemplate;
import com.geo.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author geooo
 * @date 2022/8/21 11:49
 */
@Slf4j
@Component
public class RandomDiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopAmount, Long quota) {
        // 计算使用优惠券之后的价格
        Long maxBenefit = Math.min(shopAmount, quota);
        int reductionAmount = new Random().nextInt(maxBenefit.intValue());
        Long newCost = totalAmount - reductionAmount;

        log.debug("original price={}, new price={}", totalAmount, newCost );
        return newCost;
    }
}
