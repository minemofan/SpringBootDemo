package com.core.controller;

import com.common.utils.DateUtil;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.service.ITestUserServiceByMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;


/**
 * Created on 2018-02-13
 * <p>Title:       增删改查Demo</p>
 * <p>Description: 增加、删除、修改、简单查询、service-dao事务、service-bo-dao事务、翻页查询</p>
 * <p>Copyright:   Copyright (c) 2018</p>
 * <p>Company:     蚂蚁金服</p>
 * <p>Department:  财富营销</p>
 * @author         mosh
 * @version        1.0
 */
@RestController  //@RestController 继承 @Controller ,解整合了@Controller和@ResponseBody。
@RequestMapping(value = "/testuser")
public class TestUserControllerByMapper {


    @Autowired
    private ITestUserServiceByMapper iTestUserServiceByMapper;


    /**
     * Title	增加
     * Description 增http://127.0.0.1:8080/myBoot/testuser/add
     *           {"name":"minemofan","type":"1","money":"100.99","remark":"minemofan备注"}
     * @return
     * @author mosh
     * @update [日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "/add"
            ,method = {RequestMethod.POST,RequestMethod.GET}
            ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String add(@RequestBody TestUserDTO testUserDTO){
        TestUserPO po = new TestUserPO();
        po.setName(testUserDTO.getName());
        po.setType(testUserDTO.getType());
        po.setMoney(testUserDTO.getMoney());
        po.setBirthdate(DateUtil.getCurrentDate());
        po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po.setRemark(testUserDTO.getRemark());

        iTestUserServiceByMapper.add(po);
        return "新增成功！";
    }


    /**
     * Title 删除
     * Description http://127.0.0.1:8080/myBoot/testuser/del
     * @return
     * @author mosh
     * @update [日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "/del"
            ,method = RequestMethod.GET)
    @ResponseBody
    public String del(@RequestParam String name){
        boolean flag = iTestUserServiceByMapper.deleteByName(name);
        String msg = "删除名称为："+ name +"的数据。"+ flag;
        return "删除成功！"+ msg;
    }

    /**
     * Title 更新
     * Description http://127.0.0.1:8080/core_web/demoController/up.mvc
     * @return
     * @author mosh
     * @update [日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "/up"
            ,method = RequestMethod.GET
            ,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modify(@RequestBody TestUserDTO testUserDTO){

        TestUserPO po = new TestUserPO();
        po.setId(testUserDTO.getId());
        po.setName(testUserDTO.getName());
        po.setRemark(testUserDTO.getRemark());

        boolean flag = iTestUserServiceByMapper.updateById(po);
        String msg = "修改名称为："+ po.getName() +"的数据。"+ flag;
        return "更新成功！"+ msg;
    }



}
