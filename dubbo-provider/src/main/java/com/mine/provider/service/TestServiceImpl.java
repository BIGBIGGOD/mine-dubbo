package com.mine.provider.service;

import com.mine.api.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by jiangqd on 2019/3/13.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public void say() {
        System.out.println("你好啊");
    }
}
