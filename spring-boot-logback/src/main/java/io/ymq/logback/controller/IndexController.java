package io.ymq.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-10-30 14:20
 **/
@RestController
@RequestMapping("/")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping(value = {""})
    public String index() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LOGGER.info("测试 logback：{}",localDateTime);

        return "测试 logback：" + localDateTime;
    }
}
