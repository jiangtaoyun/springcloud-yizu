package com.jk.service;

import com.jk.model.SouWork;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "springclond-provider-sousuo")
public interface FeignService {
    @RequestMapping("queryWork")
    @ResponseBody
    List<SouWork> queryWork(SouWork souWork);
    @GetMapping("query")
    @ResponseBody
    List<SouWork> query();
}
