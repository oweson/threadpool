package com.example.threadpool.service;

import com.example.threadpool.config.GlobalConfig;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/4 21:31
 */
@Service
public class BootService {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = GlobalConfig.defaultThreadPool();
   // @Scheduled(fixedRate = 15000)
    public void  done() throws InterruptedException {
        //GlobalConfig globalConfig = new GlobalConfig();
        for (int i = 0; i < 20; i++) {
            threadPoolTaskExecutor.execute(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"    :======================================");
            });
           // hello();
        }
    }

    public void demo1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(java.lang.Thread.currentThread().getName());
    }
    @Async
    public void hello() throws InterruptedException {
       Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"     :===============================================");
    }
    @Async
    public void helloWorld() throws InterruptedException {
        Thread.sleep(1200);
        System.out.println(Thread.currentThread().getName()+"   :===================================================");
    }
    @Resource(name = "defaultThreadPool")
    private ThreadPoolTaskExecutor poolTaskExecutor;

    @Async
    public void testPool() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }
   @Async
    public void testNoPool() {
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    public int testPoolTaskExecutor(int n) throws InterruptedException, ExecutionException {
        CountDownLatch countDownLatch = new CountDownLatch(n);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            final int index = i;
            final Future<Integer> future = poolTaskExecutor.submit(() -> {
                Thread.sleep(5000);
                System.out.println(simpleDateFormat.format(new Date())+" "+Thread.currentThread().getName() + " 执行 " + index);
                countDownLatch.countDown();
                return 1;
            });
        }
        countDownLatch.await();
        return sum;
    }
}
