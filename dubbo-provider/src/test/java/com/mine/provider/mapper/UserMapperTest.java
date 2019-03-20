package com.mine.provider.mapper;

import com.mine.provider.BaseJunit4Test;
import com.mine.provider.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jiangqd on 2019/3/13.
 */
//@Slf4j
public class UserMapperTest extends BaseJunit4Test {

    Logger log = LoggerFactory.getLogger(UserMapperTest.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        log.info("---****Provider 启动****-----");
        List<User> list = userMapper.getUser();
        System.out.println(list);
    }

}
