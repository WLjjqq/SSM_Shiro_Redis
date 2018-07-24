package com.shiro.service.impl;

import com.shiro.Mapper.UserMapper;
import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Create by 六
 * Date:18-7-21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public User select(String nickname) {
        User user = userMapper.select(nickname);
        redisTemplate.opsForValue().set("user",user);
        return user;
    }
}
