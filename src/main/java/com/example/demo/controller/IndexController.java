package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author by ys
 * @create by 2019/10/15
 */
@RestController
public class IndexController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/login")
    public String getString() {
        return "hello";
    }
    @RequestMapping("user/{id}")
    public String home(@PathVariable Integer id) {
        List<UserBean> list = (List<UserBean>) userDao.findAll();
        if( list == null ) return "{\"msg\":\"无数据\"}";
        Optional<UserBean> userBean=userDao.findById(id);
        return userBean.toString();
    }
}
