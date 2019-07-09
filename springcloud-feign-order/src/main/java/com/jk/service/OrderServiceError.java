package com.jk.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Component
public class OrderServiceError implements OrderService{
    @Override
    public String test() {
        return "请刷新";
    }
}
