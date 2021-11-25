package com.syd.leetcode.redis.controller;

import com.syd.leetcode.po.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @GetMapping(value = "/info")
    @Cacheable(value = "user", key = "#uid")
    public User getUser(@RequestParam(value = "uid") String uid) {
        User user = new User(uid,"syd",28,"syd@hotmail.com");
        System.out.println("getUser====>" + uid);
        return user;
    }

}
