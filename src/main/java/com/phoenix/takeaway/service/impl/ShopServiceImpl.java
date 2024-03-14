package com.phoenix.takeaway.service.impl;

import com.phoenix.takeaway.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public void setStatus(int status) {
        redisTemplate.opsForValue().set("SHOP_STATUS",status);
    }

    @Override
    public Integer getStatus() throws NullPointerException{
        return Integer.valueOf((String) Objects.requireNonNull(redisTemplate.opsForValue().get("SHOP_STATUS")));
    }
}
