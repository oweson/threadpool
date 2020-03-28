package com.example.threadpool.controller;

import com.example.threadpool.service.SendMessage;
import com.example.threadpool.service.SendMessageAsyc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/6 21:41
 */
@RestController
public class SendMessageController {
    @Autowired
    SendMessage sendMessage;
    @Autowired
    SendMessageAsyc sendMessageAsyc;
    @RequestMapping("simple")
    public void demo1() throws InterruptedException {
        sendMessage.sendEmail();
        sendMessage.senMessage01();

    }
    @RequestMapping("asyc")
    public void demo2() throws InterruptedException {
        sendMessageAsyc.sendEmail();
        sendMessageAsyc.senMessage01();

    }
}
