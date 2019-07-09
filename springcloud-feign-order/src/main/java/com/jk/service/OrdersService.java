package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider-order"/*,fallback = OrderServiceError.class*/)
public interface OrdersService extends OrderService{
}
