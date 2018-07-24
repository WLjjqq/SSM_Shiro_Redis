package com.shiro.service;

import com.shiro.entity.User;

/**
 * Create by 六
 * Date:18-7-21
 */
public interface UserService {
    User select(String nickname);
}
