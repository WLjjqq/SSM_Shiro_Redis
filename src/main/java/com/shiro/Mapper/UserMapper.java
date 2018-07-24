package com.shiro.Mapper;

import com.shiro.entity.User;
import org.apache.ibatis.annotations.Param;


/**
 * Create by 六
 * Date:18-7-21
 */
public interface UserMapper {
    User select(@Param("nickname") String nickname);
}
