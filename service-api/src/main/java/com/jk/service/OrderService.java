package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;

public interface OrderService {
    @GetMapping("test")
    String test();
}
