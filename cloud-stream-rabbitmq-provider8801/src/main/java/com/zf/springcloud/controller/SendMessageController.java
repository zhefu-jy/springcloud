package com.zf.springcloud.controller;

import com.zf.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
