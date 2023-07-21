package com.example.redis.config.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheService {

    /* Bu metodun amacı uzun bir işlem gerçekleşmesini sağlamak.
    * metod bir kere çalışır ve sonuç cache yüklenir.
    *
    * Bu metodu diğer çağırmalarda sonuç direkt olarak cache'den gelir.
     */
    @Cacheable(cacheNames = "myCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000L);
        return "Uzun Bekleme Metodu Çalıştı";
    }

    @CachePut(cacheNames = "myCache")
    public String updateCache(){
        return "Updated cache";
    }

    @CacheEvict(cacheNames = "myCache")
    public void clearCache(){
        log.info("Cache temizlendi");
    }

}
