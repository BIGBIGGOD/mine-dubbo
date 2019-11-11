package com.mine.provider.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mine.api.service.TestService;
import com.mine.provider.BaseJunit4Test;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jiangqd on 2019/3/14.
 */
@Slf4j
public class TestServiceTest extends BaseJunit4Test {

    @Autowired
    private TestService testService;

    @Test
    public void testSay() {
        testService.say();
    }

}
