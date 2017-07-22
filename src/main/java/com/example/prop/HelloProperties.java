package com.example.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/11.
 */
@ConfigurationProperties(prefix = "phello")
@PropertySource("classpath:/prop/hello.properties")
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