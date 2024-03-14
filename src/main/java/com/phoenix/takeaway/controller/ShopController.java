package com.phoenix.takeaway.controller;

import com.phoenix.takeaway.service.ShopService;
import com.phoenix.takeaway.vo.ResultVO;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/shop")
@Slf4j
@Tag(name = "店铺接口")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/status")
    @Operation(summary = "获取店铺营业状态")
    public ResultVO<Integer> getStatus(){
        int states = shopService.getStatus();
        return ResultVO.success(states);
    }


    @PutMapping("/{status}")
    @Operation(summary = "设置店铺营业状态")
    public ResultVO setStatus(@PathVariable int status){
        shopService.setStatus(status);
        return ResultVO.success();
    }




}
