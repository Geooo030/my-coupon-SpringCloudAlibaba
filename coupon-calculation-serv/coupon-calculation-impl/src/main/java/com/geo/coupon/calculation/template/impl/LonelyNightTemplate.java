package com.geo.coupon.calculation.template.impl;

import com.geo.coupon.calculation.template.AbstractRuleTemplate;
import com.geo.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author geooo
 * @date 2022/8/21 11:55
 */
@Slf4j
@Component
public class LonelyNightTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (hourOfDay >= 23 || hourOfDay < 2) {
            quota *= 2;
        }

        Long benefitAmount = shopTotalAmount < quota ? shopTotalAmount : quota;
        return orderTotalAmount - benefitAmount;
    }
}
