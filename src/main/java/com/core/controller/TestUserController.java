package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.common.utils.DateUtil;
import com.common.utils.LoggerUtils;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.service.impl.TestUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * Created on 2016-01-01
 * <p>Title:       增删改查Demo</p>
 * <p>Description: 增加、删除、修改、简单查询、service-dao事务、service-bo-dao事务、翻页查询</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     科技中心</p>
 * <p>Department:  研发部</p>
 * @author         mosh
 * @version        1.0
 */
@RestController  //@RestController 继承 @Controller ,解整合了@Controller和@ResponseBody。
@RequestMapping(value = "/testuser")
public class TestUserController {

    protected static Logger _logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private TestUserServiceImpl iTestUserService;


    /**
     * Description 基础接口
     * @return
     */
    @RequestMapping(value = "/index" ,method = {RequestMethod.GET,RequestMethod.POST},produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Welcome TestUserController!欢迎";
    }


    //------------------------------------------------------------      start
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
        List<String> list = iTestUserService.getListTMock(id);
        return JSON.toJSONString(list);
    }
    //------------------------------------------------------------      end

    //------------------------------------------------------------      start   DB
    /**
     * Title	增加
     * Description 增http://127.0.0.1:8080/myBoot/testuser/add
     *           {"name":"minemofan","type":"1","money":"100.99","remark":"minemofan备注"}
     * @return
     * @author mosh
     * @update [日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "/add",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String add(@RequestBody TestUserDTO testUserDTO){
        TestUserPO po = new TestUserPO();
        po.setName(testUserDTO.getName());
        po.setType(testUserDTO.getType());
        po.setMoney(testUserDTO.getMoney());
        po.setBirthdate(DateUtil.getCurrentDate());
        po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po.setRemark(testUserDTO.getRemark());

        iTestUserService.add(po);
        return "新增成功！";
    }
    //------------------------------------------------------------      end   DB
}
