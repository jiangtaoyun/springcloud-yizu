package com.jk.Service;

import com.jk.service.Sy.SyServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 20:56
 * @Description:
 */
@FeignClient(value = "springcloud-provider-sy-fairs")
public interface SyService extends SyServiceApi {
}
