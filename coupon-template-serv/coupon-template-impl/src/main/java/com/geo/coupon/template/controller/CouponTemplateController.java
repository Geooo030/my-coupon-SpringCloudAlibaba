package com.geo.coupon.template.controller;

import com.alibaba.fastjson.JSON;
import com.geo.coupon.template.api.beans.CouponTemplateInfo;
import com.geo.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.geo.coupon.template.api.beans.TemplateSearchParams;
import com.geo.coupon.template.api.controller.CouponTemplateServiceApi;
import com.geo.coupon.template.api.dto.GetTemplateInBatchDTO;
import com.geo.coupon.template.service.intf.CouponTemplateService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Slf4j
@RestController
public class CouponTemplateController implements CouponTemplateServiceApi {

    @Autowired
    private CouponTemplateService couponTemplateService;

    // 创建优惠券
    public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
        log.info("Create coupon template: data={}", request);
        return couponTemplateService.createTemplate(request);
    }

    // 拷贝优惠券模板
    public CouponTemplateInfo cloneTemplate(@RequestParam("id") Long templateId) {
        log.info("Clone coupon template: data={}", templateId);
        return couponTemplateService.cloneTemplate(templateId);
    }

    // 读取优惠券
    public CouponTemplateInfo getTemplate(@NotNull @RequestBody Long id) {
        log.info("Load template, id={}", id);
        return couponTemplateService.loadTemplateInfo(id);
    }

    // 批量获取
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(@Validated @RequestBody GetTemplateInBatchDTO dto) {
        log.info("getTemplateInBatch: {}", JSON.toJSONString(dto.getIds()));
        return couponTemplateService.getTemplateInfoMap(dto.getIds());
    }

    // 搜索模板
    @PostMapping("/search")
    public PagedCouponTemplateInfo search(@Valid @RequestBody TemplateSearchParams request) {
        log.info("search templates, payload={}", request);
        return couponTemplateService.search(request);
    }

    // 优惠券无效化
    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestBody Long id) {
        log.info("Load template, id={}", id);
        couponTemplateService.deleteTemplate(id);
    }
}
