package com.example.redis.controller;

import com.example.redis.config.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {
    private int count = 0;
    private final RedisCacheService redisCacheService;

    public RedisCacheController(RedisCacheService redisCacheService){
        this.redisCacheService = redisCacheService;
    }

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if(count == 5){
            redisCacheService.clearCache();
            count = 0;
        }
        count++;
        return redisCacheService.longRunningMethod();
    }

    @PutMapping
    public String cacheUpdate(){
        return redisCacheService.updateCache();
    }
}
