package com.lls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 */
@Entity
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @Column(length = 25,nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
