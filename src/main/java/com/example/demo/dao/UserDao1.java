package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * @author by ys
 * @create by 2019/10/17
 */
@Service
public class UserDao1 {

    @Autowired
    EntityManager entityManager;

}
