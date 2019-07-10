package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "springcloud-provider-user")
public interface FeignUserService extends UserService{
}
