package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/11.
 * Description 全局的配置文件读取
 */
@RestController
@EnableAutoConfiguration
public class AppController {

    @Value("${app.sb}")
    private String  sb;

    @Value("${app.name}")
    private String  name;

    @Value("${app.des}")
    private String  des;

    @RequestMapping("/app")
    public String index(){
        System.out.println("app!"+ sb);
        System.out.println("app!"+ name);
        return des;
    }

}
