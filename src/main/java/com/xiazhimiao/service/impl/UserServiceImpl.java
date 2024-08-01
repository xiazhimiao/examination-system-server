package com.xiazhimiao.service.impl;


import com.xiazhimiao.mapper.UserMapper;
import com.xiazhimiao.pojo.User;
import com.xiazhimiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public int register(User user) {
         return userMapper.register(user);
    }

    @Override
    public User getUsername(User user) {
        return userMapper.getUsername(user);
    }

    @Override
    public User userInfoService(Integer id) {
        return userMapper.userInfoService(id);
    }
}
