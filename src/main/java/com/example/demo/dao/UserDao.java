package com.example.demo.dao;

import com.example.demo.bean.UserBean;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author by ys
 * @create by 2019/10/15
 */
public interface UserDao extends CrudRepository<UserBean,Integer> {

}
