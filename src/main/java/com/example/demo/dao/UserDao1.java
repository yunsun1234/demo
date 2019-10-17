package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author by ys
 * @create by 2019/10/17
 */
@Repository
public class UserDao1 {

    @PersistenceContext
    EntityManager entityManager;

    public User addUser(User user){
        //调用EntityManager中的保存方法merge
        user=entityManager.merge(user);
        //及时的存入数据库
        entityManager.flush();
        return user;
    }

    public int deleteUser(Integer id){
        Query query=entityManager.createQuery("delete from User where id=:id")
        .setParameter("id",id);
        int number=query.executeUpdate();
        return number;
    }

    public User getUserById(int id) {
        Query query=entityManager.createQuery("from User where id=:id")
                .setParameter("id",id);
        if(query.getResultList().size()>0){
            return (User)query.getSingleResult();
        }else {
            return null;
        }
    }

    public User updateUser(User user){
        return entityManager.merge(user);
    }
}
