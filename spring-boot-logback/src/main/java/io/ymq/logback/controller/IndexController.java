package io.ymq.logback.controller;

import io.ymq.logback.config.annotation.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-10-30 14:20
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    /**
     * http://127.0.0.1:/index/?content="我是测试内容"
     *
     * @param content
     * @return
     */
    @Log("首页IndexController")
    @RequestMapping(value="", method= RequestMethod.GET)
    public String index(@RequestParam String content) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LOGGER.info("测试 logback：{},content:{}", localDateTime, content);

        return "测试 logback：" + localDateTime + ",content:" + content;
    }
}
