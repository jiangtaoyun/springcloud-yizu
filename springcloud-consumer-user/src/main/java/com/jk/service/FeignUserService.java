package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author:slm
 * @Date：
 **/
@FeignClient(value = "springcloud-provider-user")
public interface FeignUserService extends UserService{
}
