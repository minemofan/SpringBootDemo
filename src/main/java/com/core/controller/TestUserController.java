package com.core.controller;

import com.core.service.impl.TestUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/testuser")
public class TestUserController {

    @Autowired
    private TestUserServiceImpl iTestUserService;



}
