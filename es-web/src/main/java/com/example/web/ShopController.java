package com.example.web;

import com.example.DTO.ResultDTO;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "getShopUser", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO getShopUser(){
        return ResultDTO.success(shopService.getShopUser());
    }

    @RequestMapping(value = "transactionTest", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO transactionTest(){
        shopService.updateSomething();
        return ResultDTO.success(null);
    }

    @RequestMapping(value = "transactionTest2", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO transactionTest2(){
        shopService.updateSomething2();
        return ResultDTO.success(null);
    }

    @RequestMapping(value = "transactionTest3", method = RequestMethod.GET)
    @ResponseBody
    public ResultDTO transactionTest3(){
        shopService.updateSomething3();
        return ResultDTO.success(null);
    }

}
