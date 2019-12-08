package com.servlet.study;

import java.util.Date;

/**
 * @author: yiqq
 * @date: 2018/8/22
 * @description:
 */
public class Person {
    private String name;
    private String sex;
    private int age;
    private boolean married;
    private Date birthday;
    /**
     * 无参构造函数
     */
    public Person() {
     }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
