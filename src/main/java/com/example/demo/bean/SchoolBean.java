package com.example.demo.bean;

import javax.persistence.*;

/**
 * @author by ys
 * @create by 2019/10/16
 */
@Entity
public class SchoolBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String schoolName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "headMaster_id")
    private HeadMasterBean headMaster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public HeadMasterBean getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(HeadMasterBean headMaster) {
        this.headMaster = headMaster;
    }
}
