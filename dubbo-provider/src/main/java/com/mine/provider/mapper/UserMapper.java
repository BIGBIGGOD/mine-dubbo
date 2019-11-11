package com.mine.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mine.provider.entity.User;

/**
 * Created by jiangqd on 2019/3/13.
 */
@Repository
public interface UserMapper {

    @Select("select id, username as name, password as pwd from user")
    List<User> getUser();

}
