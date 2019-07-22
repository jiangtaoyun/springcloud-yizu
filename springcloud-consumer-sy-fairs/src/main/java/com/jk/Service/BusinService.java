package com.jk.Service;

import com.jk.service.BusinServiceAPIZcy;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:47
 * @Description:
 */
@FeignClient(value = "springcloud-provider-sy-fairs")
public interface BusinService extends BusinServiceAPIZcy {
}
