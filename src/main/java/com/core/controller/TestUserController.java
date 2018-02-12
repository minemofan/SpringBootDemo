package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.common.utils.DateUtil;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.service.impl.TestUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
