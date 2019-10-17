package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao1;
import com.example.demo.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author by ys
 * @create by 2019/10/17
 */
@Service
@Transactional
public class User1ServiceImpl implements User1Service {
    @Autowired
    private UserDao1 userDao1;
    @Override
    public User getUserById(int id) {
        return userDao1.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao1.updateUser(user);
    }

    @Override
    public User createUser(User user) {
        return userDao1.addUser(user);
    }

    @Override
    public int delUserById(int id) {
        return userDao1.deleteUser(id);
    }
}
