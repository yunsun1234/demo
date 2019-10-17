package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author by ys
 * @create by 2019/10/17
 */
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name",columnDefinition = "用户名")
    private String name;
    @Column(name = "user_age",columnDefinition = "年龄")
    private int age;
}
