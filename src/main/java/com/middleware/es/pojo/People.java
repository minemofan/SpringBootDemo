/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.middleware.es.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * ES索引-文档实体
 * @author shihong.msh
 * @version $Id: People.java, v 0.1 2018年08月27日 下午6:40 shihong.msh Exp $
 */
@Document(indexName = "people", type = "man", shards = 3, replicas = 0, refreshInterval = "-1")
public class People implements Serializable{

    @Id
    private Long id;

    private String name;

    private String country;

    private Integer age;

    private Date date;

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>country</tt>.
     *
     * @return property value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for property <tt>country</tt>.
     *
     * @param country value to be assigned to property country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Getter method for property <tt>date</tt>.
     *
     * @return property value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for property <tt>date</tt>.
     *
     * @param date value to be assigned to property date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }
}