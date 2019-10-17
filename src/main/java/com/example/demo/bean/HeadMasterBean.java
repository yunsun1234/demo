package com.example.demo.bean;

import javax.persistence.*;

/**
 * @author by ys
 * @create by 2019/10/16
 */
@Entity
@Table(name="head_master")
public class HeadMasterBean {
    /**
     * 一对一映射，HeadMaster与school的关系
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
    private Integer id;

    @Column(name= "head_master_name")
    private String headMasterName;

    @OneToOne(mappedBy = "headMaster")
    private SchoolBean school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadMasterName() {
        return headMasterName;
    }

    public void setHeadMasterName(String headMasterName) {
        this.headMasterName = headMasterName;
    }

    public SchoolBean getSchool() {
        return school;
    }

    public void setSchool(SchoolBean school) {
        this.school = school;
    }
}
