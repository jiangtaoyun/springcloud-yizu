package com.jk.controller;

import com.jk.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderTestController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("test")
    public String test(){
        return ordersService.test();
    }
}
