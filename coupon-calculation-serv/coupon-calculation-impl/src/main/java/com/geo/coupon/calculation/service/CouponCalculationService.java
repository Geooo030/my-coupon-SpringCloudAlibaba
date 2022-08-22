package com.geo.coupon.calculation.service;

import com.geo.coupon.calculation.api.beans.ShoppingCart;
import com.geo.coupon.calculation.api.beans.SimulationOrder;
import com.geo.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Geooo
 * @date 2022/8/21 19:18
 */
public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(ShoppingCart cart);

    SimulationResponse simulateOrder(SimulationOrder order);
}
