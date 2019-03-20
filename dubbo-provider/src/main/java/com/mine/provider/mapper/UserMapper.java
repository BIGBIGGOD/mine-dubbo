package com.mine.provider.mapper;

import com.mine.provider.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jiangqd on 2019/3/13.
 */
@Repository
public interface UserMapper {

    @Select("select id, username as name, password as pwd from user")
    List<User> getUser();

}
