package com.example.threadpool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/6 21:26
 */
@Service
public class SendMessageAsyc {
    @Async
    public void senMessage01() throws InterruptedException {
        System.out.println("发送短信开始！");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("发送短信结束！");
    }
    @Async
    public void sendEmail() throws InterruptedException {
        System.out.println("发送邮件开始");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("发送邮件结束了");
    }
}
