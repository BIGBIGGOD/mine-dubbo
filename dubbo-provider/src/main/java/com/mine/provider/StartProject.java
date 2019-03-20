package com.mine.provider;

import com.mine.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangqd on 2019/3/14.
 */
@Slf4j
public class StartProject {

    /**
     * @param args 本地启动所需的主方法
     */
    public static void main(String[] args) {
        log.info("---****Provider 启动****-----");
        ClassPathXmlApplicationContext context =
//            new ClassPathXmlApplicationContext("classpath:spring/spring-db.xml", "spring/applicationContext.xml");
            new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        context.start();
        System.out.println("Provider Server Started!");
//        TestService testService = (TestService) context.getBean("testService");
//        testService.say();
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
