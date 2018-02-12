package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.common.utils.LoggerUtils;
import com.core.pojo.dto.TestUserDTO;
import com.core.service.impl.TestUserServiceByIndexImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //@RestController 继承 @Controller ,解整合了@Controller和@ResponseBody。
@RequestMapping(value = "/testuser")
public class TestUserControllerByIndex {

    protected static Logger _logger = LoggerFactory.getLogger(TestUserControllerByIndex.class);

    @Autowired
    private TestUserServiceByIndexImpl iTestUserDaoByIndex;

    /**
     * Description 基础接口
     * @return
     */
    @RequestMapping(value = "/index" ,method = {RequestMethod.GET,RequestMethod.POST},produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Welcome TestUserController!欢迎";
    }


    /**
     * Description 定义请求报文为JSON格式
     *      postman  http://localhost:8080/myBoot/testuser/query
     *               {"id":123,"name":"minemofan"}
     * @param testUserDTO
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String query(@RequestBody TestUserDTO testUserDTO){
        LoggerUtils.info(_logger, "[testUser查询接口]testUserDTO:"+ testUserDTO);
        LoggerUtils.info(_logger, "[testUser查询接口]日志参数1：{0},日志参数2：{1}。",123, "OneTwoThree");
        return "Welcome TestUserController！id:"+ testUserDTO.getName();
    }


    /**
     * Description
     *      http://localhost:8080/myBoot/testuser/tmock?id=1
     * @param id
     * @return
     */
    @RequestMapping(value = "/tmock",method = RequestMethod.GET)
    public String queryTMock(@RequestParam String id){
        List<String> list = iTestUserDaoByIndex.getListTMock(id);
        return JSON.toJSONString(list);
    }

}
