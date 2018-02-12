package com.core.service;

import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.pojo.vo.DemoVO;

import java.util.List;
import java.util.Map;

public interface ITestUserService {


    /**
     * Description： 增加
     * @param po
     */
    public void add(TestUserPO po);

    /**
     * Description 查询所有
     * @return
     */
    public List<TestUserDTO> queryAll();

    /**
     * Description 根据id查询所有USER信息
     * @param id
     * @return
     */
    public List<TestUserDTO> queryAllById(Integer id);

    /**
     * Description 根据传入参数查询USER信息
     * @param param
     * @return
     */
    public List<TestUserDTO> queryAllByMap(Map<String,Object> param);

    /**
     * Description 根据ID更新USER信息
     * @param vo
     * @return
     */
    public boolean updateById(DemoVO vo);

    /**
     * Description 根据NAME删除对应的USER信息
     * @param name
     * @return
     */
    public boolean deleteByName(String name);

    /**
     * Title	翻页查询
     * Description    mysql利用limit >> offset,pageSize（10，10） 表示从第十一条开始，取10条数据
     * @param param
     * @return
     */
    public List<TestUserDTO> queryByLimit(Map<String,Object> param);

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

    /**
     * Title	AOP事务
     * Description  验证Service事务
     * @return
     */
    public boolean valiTransationByAOP();


    /**
     * Title	Annotation事务
     * Description  验证Service事务
     * @return
     */
    public boolean valiTransationByAnnotation();


    /**
     * Title	结合BO的事务
     * Description  验证结合BO的事务（BO是一个原子，当报错时，同时回滚BO、DAO）
     * @return
     */
    public boolean valiTransationByBO();

}
