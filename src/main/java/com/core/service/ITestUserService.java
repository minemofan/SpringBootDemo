package com.core.service;

import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;

import java.util.List;
import java.util.Map;

public interface ITestUserService {


    /**
     * Title	一对一查询
     * Description
     * @param param
     * @return
     */
    public List<TestUserDTO> queryOne2One(Map<String,Object> param);

    /**
     * Title	一对多查询
     * Description
     * @param param
     * @return
     */
    public List<TestUserDTO> queryOne2Many(Map<String,Object> param);

    /**
     * Title	多对一查询
     * Description
     * @param param
     * @return
     */
    public List<TestMobileDTO> queryMany2One(Map<String,Object> param);

    /**
     * Title	多对多查询
     * Description
     * @param param
     * @return
     */
    public List<TestUserDTO> queryMany2Many1(Map<String,Object> param);

    /**
     * Title	多对多查询
     * Description
     * @param param
     * @return
     */
    public List<TestUserDTO> queryMany2Many2(Map<String,Object> param);






}
