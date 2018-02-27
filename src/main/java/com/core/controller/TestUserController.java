package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.common.utils.LoggerUtils;
import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestRoleDTO;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.dto.TestUserRoleDTO;
import com.core.service.impl.TestUserServiceByMapperImpl;
import com.core.service.impl.TestUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TestUserServiceByMapperImpl iTestUserServiceByMapper;


    /**
     * Title 简单查询、翻页、一对多、多对一、一对一、多对多
     * Description http://127.0.0.1:8080/core_web/demoController/page/queryAll
     * @return ModelAndView
     * @author mosh
     * @update:	[日期YYYY-MM-DD] [更改人姓名]
     */
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public String query(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){

        //查询
        List<TestUserDTO> allList = iTestUserServiceByMapper.queryAll();
        modelAndView.addObject("allList", allList);
        LoggerUtils.info(_logger, "[testUser查询接口]简单查询:{0}。", allList);


        //条件查询1
        int id = 1;
        List<TestUserDTO> listByUid = iTestUserServiceByMapper.queryAllById(new Integer(id));
        modelAndView.addObject("listByUid", listByUid);
        LoggerUtils.info(_logger, "[testUser查询接口]条件查询1:{0}。", listByUid);

        //条件查询2
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("ids", new long[]{1,2,3,4,5,6,7});
        param.put("name", "名");
        List<TestUserDTO> listByMap = iTestUserServiceByMapper.queryAllByMap(param);
        modelAndView.addObject("listByMap", listByMap);
        LoggerUtils.info(_logger, "[testUser查询接口]条件查询2:{0}。", listByMap);


        //翻页查询
        Map<String,Object> limitMap = new HashMap<String,Object>();
        limitMap.put("offset", "10");	//从第十一条开始
        limitMap.put("pageSize", "10"); //取10条数据
        List<TestUserDTO> limitList = iTestUserServiceByMapper.queryByLimit(limitMap);
        modelAndView.addObject("limitList", limitList);
        LoggerUtils.info(_logger, "[testUser查询接口]翻页查询:{0}。", limitList);

        //一对一
        Map<String,Object> one2OneMap = new HashMap<String,Object>();
        one2OneMap.put("name", "");
        List<TestUserDTO> one2OneList = iTestUserService.queryOne2One(one2OneMap);

        LoggerUtils.info(_logger, "[testUser查询接口]一对一查询:{0}。", one2OneList);

        for(int i=0;i<one2OneList.size();i++){
            TestUserDTO dto = one2OneList.get(i);
            Integer uid = dto.getId();
            String name = dto.getName();
            LoggerUtils.info(_logger, "一对一查询：id:{0},name:{1},idCardDTO:{2}。", uid, name, dto.getIdCard());
        }

        //一对多
        Map<String,Object> one2ManyMap = new HashMap<String,Object>();
        one2ManyMap.put("name", null);
        List<TestUserDTO> one2ManyList = iTestUserService.queryOne2Many(one2ManyMap);

        LoggerUtils.info(_logger, "[testUser查询接口]一对多查询:{0}。", one2ManyList);

        for(int i=0;i<one2ManyList.size();i++){
            TestUserDTO dto = one2ManyList.get(i);
            Integer uid = dto.getId();
            String name = dto.getName();
            LoggerUtils.info(_logger, "一对多查询：id:{0},name:{1},Mobiles:{2}。", uid, name, dto.getMobiles().size());
        }

        //多对一
        Map<String,Object> Many2OneMap = new HashMap<String,Object>();
        Many2OneMap.put("name", null);
        List<TestMobileDTO> Many2OneList = iTestUserService.queryMany2One(Many2OneMap);

        LoggerUtils.info(_logger, "[testUser查询接口]多对一查询:{0}。", Many2OneList);

        for(int i=0;i<Many2OneList.size();i++){
            TestMobileDTO dto = Many2OneList.get(i);
            Integer mid = dto.getId();
            Long mobileNum = dto.getMobileNum();
            LoggerUtils.info(_logger, "多对一查询：id:{0},mobileNum:{1},user:{2}。", mid, mobileNum, dto.getUser().getId());
        }

        //多对多1
        Map<String,Object> Many2ManyMap = new HashMap<String,Object>();
        List<TestUserDTO> Many2ManyList = iTestUserService.queryMany2Many1(Many2ManyMap);

        LoggerUtils.info(_logger, "[testUser查询接口]多对多查询:{0}。", Many2ManyList);

        for(int i=0;i<Many2ManyList.size();i++){
            TestUserDTO dto = Many2ManyList.get(i);
            Integer uid = dto.getId();
            String uname = dto.getName();
            LoggerUtils.info(_logger, "多对多查询：id:{0},user:{1},Role:{2}。", uid, uname, dto.getRoles().size());
        }
        /*多对多2    新版本mapper返回值映射报 NULL
        Map<String,Object> Many2ManyMap2 = new HashMap<String, Object>();
        List<TestUserDTO> Many2ManyList2 = iTestUserService.queryMany2Many2(Many2ManyMap2);


        LoggerUtils.info(_logger, "[testUser查询接口]多对多查询2:{0}。", Many2ManyList2);

        for(int i=0;i<Many2ManyList2.size();i++){
            TestUserDTO dto = Many2ManyList2.get(i);
            Integer uid = dto.getId();
            String uname = dto.getName();

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            List<TestUserRoleDTO> userRoles = dto.getUserRoles();
            for(int j=0;j<userRoles.size();j++){
                TestUserRoleDTO urDto = userRoles.get(j);
                TestRoleDTO role = urDto.getRole();
                sb.append("角色："+ role.getRoleName() +"—");
            }
            sb.append("]");
            LoggerUtils.info(_logger, "多对多查询2：id:{0},user:{1},Role:{2}。", uid, uname, sb.toString());
        }*/

        modelAndView.setViewName("index");		//返回JSP
        return JSON.toJSONString(modelAndView);
    }

}
