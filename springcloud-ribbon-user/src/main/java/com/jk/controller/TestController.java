package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("find/{name}")
    public String find(@PathVariable("name") String name){
        String result = restTemplate.getForObject("http://springcloud-provider-user/postm/" + name, String.class);
        return result;
    }

}
