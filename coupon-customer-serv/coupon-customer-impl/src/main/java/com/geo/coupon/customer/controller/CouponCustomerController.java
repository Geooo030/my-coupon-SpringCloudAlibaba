package com.geo.coupon.customer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import com.geo.coupon.customer.api.beans.RequestCoupon;
import com.geo.coupon.customer.api.beans.SearchCoupon;
import com.geo.coupon.customer.dao.entity.Coupon;
import com.geo.coupon.customer.service.intf.CouponCustomerService;
import com.geo.coupon.template.api.beans.CouponInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coupon-customer")
public class CouponCustomerController {

    @Autowired
    private CouponCustomerService customerService;

    @PostMapping("/requestCoupon")
    @SentinelResource("customer-requestCoupon")
    public Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
        return customerService.requestCoupon(request);
    }

    // 用户删除优惠券
    @DeleteMapping("/deleteCoupon")
    public void deleteCoupon(@RequestParam("userId") Long userId,
                                       @RequestParam("couponId") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }

    // 用户模拟计算每个优惠券的优惠价格
    @PostMapping("/simulateOrder")
    public SimulationResponse simulate(@Valid @RequestBody SimulationOrder order) {
        return customerService.simulateOrderPrice(order);
    }

    // ResponseEntity - 指定返回状态码 - 可以作为一个课后思考题
    @PostMapping("/placeOrder")
    public ShoppingCart checkout(@Valid @RequestBody ShoppingCart info) {
        return customerService.placeOrder(info);
    }


    // 实现的时候最好封装一个search object类
    @PostMapping("/findCoupon")
    public List<CouponInfo> findCoupon(@Valid @RequestBody SearchCoupon request) {
        return customerService.findCoupon(request);
    }

}
