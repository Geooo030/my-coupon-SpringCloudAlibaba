package com.geo.coupon.calculation.api.beans;


import com.geo.coupon.template.api.beans.CouponInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    // 订单的商品列表 -
    @NotEmpty
    private List<Product> products;


    // 封装了优惠券信息，目前计算服务只支持单张优惠券
    private Long couponId;

    // 为了考虑到以后多券的扩展性，所以定义成了List
    private List<CouponInfo> couponInfos;

    // 订单的最终价格 价格 -- 分
    private long cost;

    // 用户ID
    @NotNull
    private Long userId;


}
