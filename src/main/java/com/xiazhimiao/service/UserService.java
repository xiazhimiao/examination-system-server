package com.xiazhimiao.service;


import com.xiazhimiao.pojo.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User login(User emp);

    int register(User user);

    User getUsername(User user);

    User userInfoService(Integer id);
}
