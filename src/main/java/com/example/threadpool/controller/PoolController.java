package com.example.threadpool.controller;

import com.example.threadpool.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/4 21:35
 */
@RestController
public class PoolController {
    @Autowired
    private BootService bootService;

    @RequestMapping("oneOrMany")
    public void hello01() throws InterruptedException {
        bootService.demo1();

    }

    @RequestMapping("hello")
    public Object hello() throws InterruptedException {
        // bootService.helloWorld();
        bootService.done();
        return "hello";
    }

    @RequestMapping("/pool")
    public String pool() {
        for (int i = 0; i < 100; i++) {
            bootService.testPool();
        }
        return "pool test";
    }

    @RequestMapping("/poolTask/{n}")
    public String poolTask(@PathVariable int n) {
        long startTime = System.currentTimeMillis();
        try {
            bootService.testPoolTaskExecutor(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return "poolTask test " + (endTime - startTime) / 1000 + " 秒";
        // poolTask test 120 秒 理论100S
    }
}
