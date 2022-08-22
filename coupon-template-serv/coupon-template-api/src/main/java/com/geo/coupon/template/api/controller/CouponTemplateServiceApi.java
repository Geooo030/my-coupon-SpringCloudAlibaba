package com.geo.coupon.template.api.controller;

import com.geo.coupon.template.api.beans.CouponTemplateInfo;
import com.geo.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.geo.coupon.template.api.beans.TemplateSearchParams;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RequestMapping("/template")
public interface CouponTemplateServiceApi {

    @PostMapping("/addTemplate")
    CouponTemplateInfo addTemplate(CouponTemplateInfo request);

    @PostMapping("/cloneTemplate")
    CouponTemplateInfo cloneTemplate(Long templateId);

    @GetMapping("/getTemplate")
    CouponTemplateInfo getTemplate(Long id);

    @GetMapping("/getBatch")
    Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids);

    @PostMapping("/search")
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    @DeleteMapping("/deleteTemplate")
    void deleteTemplate(Long id);
}
