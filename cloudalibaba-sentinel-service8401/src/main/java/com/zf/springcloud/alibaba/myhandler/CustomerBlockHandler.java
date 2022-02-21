package com.zf.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zf.springcloud.entities.CommonResult;
import com.zf.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义 global exception --------1");
    }


    public static CommonResult handlerException2(BlockException  exception){
        return new CommonResult(444,"按客户自定义 global exception --------2");
    }
}
