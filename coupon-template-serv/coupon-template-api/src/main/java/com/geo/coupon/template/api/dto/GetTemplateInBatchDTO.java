package com.geo.coupon.template.api.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

/**
 * @author Geooo
 * @date 2022/8/26 1:17
 */
@Data
public class GetTemplateInBatchDTO {

    @NotEmpty
    Collection<Long> ids;
}
