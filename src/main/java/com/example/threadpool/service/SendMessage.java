package com.example.threadpool.service;

import org.springframework.stereotype.Service;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/6 21:26
 */
@Service
public class SendMessage {
    public void senMessage01() throws InterruptedException {
        System.out.println("发送短信开始！");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("发送短信结束！");
    }
    public void sendEmail() throws InterruptedException {
        System.out.println("发送邮件开始");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("发送邮件结束了");
    }
    public String future(){
        new Thread(()->System.out.println()).start();
        return "";
    }
}
