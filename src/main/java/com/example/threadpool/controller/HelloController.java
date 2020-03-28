package com.example.threadpool.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2020/3/11 22:59
 */
@RestController
public class HelloController {
    @Value("${server.port}")

    Integer port;

    @GetMapping("/set")

    public String set(HttpSession session) {

        session.setAttribute("user", "javaboy");

        return String.valueOf(port);

    }

    @GetMapping("/get")

    public String get(HttpSession session) {

        return session.getAttribute("user") + ":" + port;

    }

}
