package com.zf.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zf.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.zf.springcloud.entities.CommonResult;
import com.zf.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException2")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }



    @GetMapping("/rateLimit/byUrl")  //即可以按url
    @SentinelResource(value = "byUrl")  //也可以按资源名称  不写blockhandler会使用系统默认的兜底方案
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }




    @GetMapping("/rateLimit/customerBlockHandler")  //即可以按url
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")  //也可以按资源名称  不写blockhandler会使用系统默认的兜底方案
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial003"));
    }



}
