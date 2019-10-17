package com.example.demo.service.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author by ys
 * @create by 2019/10/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Optional<UserBean> findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        boolean flag;
        try {
            userDao.deleteById(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }

    @Override
    public boolean saveUser(UserBean userBean) {
        boolean flag;
        try{
            userDao.save(userBean);
            flag=true;
        }catch (Exception e){
            flag=false;
            e.printStackTrace();
        }
         return flag;
    }

    @Override
    public boolean update(UserBean userBean) {
        boolean flag;
        try{
            userDao.save(userBean);
            flag=true;
        }catch (Exception e){
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<UserBean> findAll() {
        return (List<UserBean>) userDao.findAll();
    }
}
