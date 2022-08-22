package com.geo.coupon.calculation.template;

import com.geo.coupon.calculation.api.beans.ShoppingCart;

/**
 * @author geooo
 * @date 2022/8/20 22:17
 */

public interface RuleTemplate {

    // 计算优惠券
    ShoppingCart calculate(ShoppingCart settlement);
}
