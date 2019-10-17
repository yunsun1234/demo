package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao1;
import com.example.demo.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by ys
 * @create by 2019/10/17
 */
@RestController
@RequestMapping("/users")
public class UserDao1Controller {
    @Autowired
    private User1Service user1Service;

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id) {
        return user1Service.delUserById(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        User user = user1Service.getUserById(id);
        return user;
    }

    @PostMapping("/addition")
    public User addUser() {
        User user = new User();
        user.setName("aa");
        user.setAge(18);
        return user1Service.createUser(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id) {
        User user = new User();
        user.setAge(28);
        user.setId(id);
        user.setName("hello");
        return user1Service.updateUser(user);
    }
}
