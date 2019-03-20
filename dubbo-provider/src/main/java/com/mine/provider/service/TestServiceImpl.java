package com.mine.provider.service;

import com.mine.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by jiangqd on 2019/3/13.
 */
@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public void say() {
        System.out.println("你好啊,我是TestService中的say方法输出");
        log.info("你好啊,我是TestService中的say方法输出");
    }

    @Override
    public int say2() {
        return 100;
    }
}
