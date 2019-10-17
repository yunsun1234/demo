package com.example.demo.service;

import com.example.demo.bean.UserBean;

import java.util.List;
import java.util.Optional;

/**
 * @author by ys
 * @create by 2019/10/15
 */
public interface UserService {
    Optional<UserBean> findById(int id);
    boolean deleteById(int id);
    boolean saveUser(UserBean userBean);
    boolean  update(UserBean userBean);
    List<UserBean> findAll();
}
