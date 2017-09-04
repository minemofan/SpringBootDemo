package com.example.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/11.
 *
 * @ Component 用于将所标注的类加载到 Spring 环境中，需要搭配 component-scan 使用
 *      ；component是spring扫描组件时的标识。
 *
 */
@ConfigurationProperties(prefix = "phello")
@PropertySource("classpath:/prop/dev/hello.properties")
@Component
public class HelloProperties {

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}