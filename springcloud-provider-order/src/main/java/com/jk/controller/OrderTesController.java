package com.jk.controller;

import com.jk.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderTesController implements OrderService {
    @Override
    @GetMapping("test")
    public String test() {
        return "进入生产者success";
    }
}
