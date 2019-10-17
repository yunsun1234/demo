package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author by ys
 * @create by 2019/10/15
 */
@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService user;

    @PostMapping("/addition")
    public UserBean insertUser(@RequestBody UserBean userBean) {
        user.saveUser(userBean);
        return userBean;
    }


    @DeleteMapping("/deletion /{id}")
    public UserBean deleteUser(@PathVariable int id) {
        user.deleteById(id);
        return new UserBean();
    }


    @PutMapping("/user")
    public UserBean updateUser(@RequestBody UserBean userBean) {
        user.saveUser(userBean);
        return userBean;
    }

    @GetMapping("/user")
    public List<UserBean> managerUser(@RequestBody UserBean userBean) {
        user.saveUser(userBean);
        return user.findAll();
    }
}
