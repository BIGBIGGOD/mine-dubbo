package com.mine.consumer.controller;

import com.mine.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiangqd on 2019/3/13.
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/say1")
    public ModelAndView say1(ModelAndView mode) {
        log.error("你好啊1");
        log.warn("你好啊1");
        logger.error("你好啊2");
        logger.warn("你好啊2");
        System.out.println("你好啊3");
        mode.setViewName("redirect:index.jsp");
        return mode;
    }

    @RequestMapping("/say2")
    public ModelAndView say2(ModelAndView mode) {
        log.info("你好啊1");
        logger.info("你好啊2");
        System.out.println("你好啊3");
        mode.setViewName("test");
        int i = testService.say2();
        return mode;
    }

    @RequestMapping("/say3")
    public String say3(ModelAndView mode) {
        log.info("你好啊1");
        logger.info("你好啊2");
        System.out.println("你好啊3");
        mode.setViewName("test");
        return "test";
    }
}
