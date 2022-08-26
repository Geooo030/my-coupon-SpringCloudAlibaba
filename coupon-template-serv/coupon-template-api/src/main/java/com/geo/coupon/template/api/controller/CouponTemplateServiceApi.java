package com.geo.coupon.template.api.controller;

import com.geo.annotation.GeoFeignClient;
import com.geo.coupon.template.api.beans.CouponTemplateInfo;
import com.geo.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.geo.coupon.template.api.beans.TemplateSearchParams;
import com.geo.coupon.template.api.dto.GetTemplateInBatchDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@GeoFeignClient(name = "coupon-template-serv")
@RequestMapping("/template")
public interface CouponTemplateServiceApi {

    @PostMapping("/addTemplate")
    CouponTemplateInfo addTemplate(CouponTemplateInfo request);

    @PostMapping("/cloneTemplate")
    CouponTemplateInfo cloneTemplate(Long templateId);

    @PostMapping("/getTemplate")
    CouponTemplateInfo getTemplate(Long id);

    @PostMapping("/getBatch")
    Map<Long, CouponTemplateInfo> getTemplateInBatch(GetTemplateInBatchDTO dto);

    @PostMapping("/search")
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    @PostMapping("/deleteTemplate")
    void deleteTemplate(Long id);
}
