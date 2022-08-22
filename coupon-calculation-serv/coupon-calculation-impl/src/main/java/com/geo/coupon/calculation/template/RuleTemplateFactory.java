package com.geo.coupon.calculation.template;

import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.template.impl.*;
import com.geo.coupon.template.api.beans.CouponTemplateInfo;
import com.geo.coupon.template.api.enums.CouponType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


/**
 * @author geooo
 * @date 2022/8/21 12:01
 */
@Slf4j
@Component
public class RuleTemplateFactory {

    @Autowired
    private EmptyTemplate emptyTemplate;

    @Autowired
    private DiscountTemplate discountTemplate;

    @Autowired
    private LonelyNightTemplate lonelyNightTemplate;

    @Autowired
    private MoneyOffTemplate moneyOffTemplate;

    @Autowired
    private RandomDiscountTemplate randomDiscountTemplate;

    @Autowired
    private AntiPauTemplate antiPauTemplate;


    public RuleTemplate getTemplate(ShoppingCart cart) {
        if (CollectionUtils.isEmpty(cart.getCouponInfos())) {
            return emptyTemplate;
        }
        // 工厂这里只取第一个优惠券进行计算，多个优惠券场景在 Service层进行逻辑处理
        CouponTemplateInfo template = cart.getCouponInfos().get(0).getTemplate();
        CouponType type = CouponType.convert(template.getType());
        switch (type) {
            // 订单满减券
            case MONEY_OFF:
                return moneyOffTemplate;
            // 随机立减券
            case RANDOM_DISCOUNT:
                return randomDiscountTemplate;
            // 午夜下单优惠翻倍
            case LONELY_NIGHT_MONEY_OFF:
                return lonelyNightTemplate;
            // 打折券
            case DISCOUNT:
                return discountTemplate;
            case ANTI_PUA:
                return antiPauTemplate;
            // 未知类型的券模板
            default:
                return emptyTemplate;
        }

    }
}
