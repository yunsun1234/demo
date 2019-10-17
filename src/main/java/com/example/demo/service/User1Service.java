package com.example.demo.service;

import com.example.demo.bean.User;

/**
 * @author by ys
 * @create by 2019/10/17
 */
public interface User1Service {
    User getUserById(int id);
    User updateUser(User user);
    User createUser(User user);
    int delUserById(int id);
}
