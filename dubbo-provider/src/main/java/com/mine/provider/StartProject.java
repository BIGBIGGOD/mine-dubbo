package com.mine.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

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
