package com.syd.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LeetcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
	}

}
