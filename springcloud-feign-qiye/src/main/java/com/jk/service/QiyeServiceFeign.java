package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider-qiye")
public interface QiyeServiceFeign extends QiyeService{
}
