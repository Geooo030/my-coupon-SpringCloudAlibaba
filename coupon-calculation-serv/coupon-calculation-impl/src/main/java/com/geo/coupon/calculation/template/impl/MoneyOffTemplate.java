package com.geo.coupon.calculation.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.geo.coupon.calculation.template.AbstractRuleTemplate;
import com.geo.coupon.calculation.template.RuleTemplate;

/**
 * 满减优惠计算
 * @author geooo
 * @date 2022/8/21 11:18
 */
@Slf4j
@Component
public class MoneyOffTemplate extends AbstractRuleTemplate implements RuleTemplate {


    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        // quota - 减掉的钱数
        // benefitAmount是扣减的价格
        // 如果当前门店的商品总价<quota，那么最多只能扣减shopAmount的钱数
        Long benefitAmount = shopTotalAmount < quota ? shopTotalAmount : quota;
        return orderTotalAmount - benefitAmount;
    }

}

