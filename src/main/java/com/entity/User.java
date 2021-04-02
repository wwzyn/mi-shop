package com.entity;

import java.util.Date;


public class User {

/*
    FieldTypeComment
    uid varchar(32)
    username varchar(20)
    password varchar(20)
    name varchar(20)
    email varchar(30)
    telephone varchar(20)
    birthday date
    sex varchar(10)
    state int(11)
    code varchar(64)*/
    private String uid ; //用户编号-----通过UUID的随机方法--->随机的字符串数据
    private String username ; //昵称
    private String password ;
    private String name  ;//真实姓名
    private String email ; //邮箱地址
    private String telephone ;//联系电话
    private Date birthday ; //出生日期
    private String sex ; //性别
    private int state ; // 默认值0,表示未激活
    private String code ;// 激活码: 通过UUID的随机方法

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}
