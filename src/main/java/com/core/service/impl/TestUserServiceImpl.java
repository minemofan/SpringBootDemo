package com.core.service.impl;

import com.common.utils.DateUtil;
import com.common.utils.LoggerUtils;
import com.core.dao.ITestUserDao;
import com.core.dao.ITestUserDaoUnTran;
import com.core.dao.mapper.ITestUserMapper;
import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.pojo.vo.DemoVO;
import com.core.service.ITestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import java.util.Map;

@Service
public class TestUserServiceImpl implements ITestUserService{

    protected static Logger _logger = LoggerFactory.getLogger(TestUserServiceImpl.class);

    @Autowired
    private ITestUserDaoUnTran iDemoDaoUnTran;

    /**
     * DAO的方式  */
    @Autowired
    private ITestUserDao iTestUserDao;

    @Autowired
    private ITestUserMapper iTestUserMapper;




    @Override
    public String getNameTMock(String id) {
        id = "service" + id;
        return iDemoDaoUnTran.getNameTMock(id);
    }

    @Override
    public List<String> getListTMock(String name) {
        name = "serviceToId" + name;
        String rstr = iDemoDaoUnTran.getNameTMock(name);
        return iDemoDaoUnTran.getListTMock(rstr);
    }




    //--------------------------------------------------   Mapper  方式

    @Override
    public void add(TestUserPO po) {
        // TODO Auto-generated method stub
        iTestUserMapper.insert(po);
        LoggerUtils.info(_logger, "add 插入：1条数据！");
    }


    @Override
    public List<TestUserDTO> queryAll() {
        // TODO Auto-generated method stub
        List<TestUserDTO> list = iTestUserMapper.queryAll();
        LoggerUtils.info(_logger, "queryInfo 查询：{0}条数据！", list.size());
        return list;
    }


    @Override
    public List<TestUserDTO> queryAllById(Integer id) {
        // TODO Auto-generated method stub
        List<TestUserDTO> list = iTestUserMapper.queryAllById(id);
        LoggerUtils.info(_logger, "queryAllById 查询：{0}条数据！", list.size());
        return list;
    }


    @Override
    public List<TestUserDTO> queryAllByMap(Map<String,Object> param) {
        // TODO Auto-generated method stub
        List<TestUserDTO> list = iTestUserMapper.queryAllByMap(param);
        LoggerUtils.info(_logger, "queryAllByMap 查询：{0}条数据！", list.size());
        return list;
    }


    @Override
    public boolean updateById(DemoVO vo) {
        // TODO Auto-generated method stub
        iTestUserMapper.updateById(vo);
        return false;
    }


    @Override
    public boolean deleteByName(String name) {
        // TODO Auto-generated method stub
        iTestUserMapper.deleteByName(name);
        return false;
    }


    @Override
    public List<TestUserDTO> queryByLimit(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserMapper.queryByLimit(param);
    }


    //--------------------------------------------------   DAO  方式

    @Override
    public List<TestUserDTO> queryOne2One(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryOne2One(param);
    }


    @Override
    public List<TestUserDTO> queryOne2Many(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryOne2Many(param);
    }


    @Override
    public List<TestMobileDTO> queryMany2One(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2One(param);
    }


    @Override
    public List<TestUserDTO> queryMany2Many1(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2Many1(param);
    }


    @Override
    public List<TestUserDTO> queryMany2Many2(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2Many2(param);
    }


    @Override
    public boolean valiTransationByAOP() {

        // TODO Auto-generated method stub
        TestUserPO po = new TestUserPO();
        po.setName("姓名AOP");
        po.setType("1");
        po.setMoney(new BigDecimal("200000.0000"));
        po.setBirthdate(DateUtil.getCurrentDate());
        po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po.setRemark("备注");
        this.add(po);

        TestUserPO po2 = new TestUserPO();
        po2.setName("姓名AOP");
        po2.setType("1");
        po2.setMoney(new BigDecimal("200000.0000"));
        po2.setBirthdate(DateUtil.getCurrentDate());
        po2.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po2.setRemark("备注");
        this.add(po2);

        Integer.parseInt("ssss");
        return false;
    }


    /**
     * Title 注解事务 （不能跟AOP同时使用，会冲突）
     * @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly=true)
     * @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
     * @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
     */
    public boolean valiTransationByAnnotation() {
        // TODO Auto-generated method stub
        TestUserPO po = new TestUserPO();
        po.setName("姓名AOP");
        po.setType("1");
        po.setMoney(new BigDecimal("200000.0000"));
        po.setBirthdate(DateUtil.getCurrentDate());
        po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po.setRemark("备注");
        this.add(po);

        TestUserPO po2 = new TestUserPO();
        po2.setName("姓名AOP");
        po2.setType("1");
        po2.setMoney(new BigDecimal("200000.0000"));
        po2.setBirthdate(DateUtil.getCurrentDate());
        po2.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po2.setRemark("备注");
        this.add(po2);

        Integer.parseInt("ssss");
        return false;
    }


    @Override
    public boolean valiTransationByBO() {
        // TODO Auto-generated method stub
        TestUserPO po = new TestUserPO();
        po.setName("姓名AOP");
        po.setType("1");
        po.setMoney(new BigDecimal("200000.0000"));
        po.setBirthdate(DateUtil.getCurrentDate());
        po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
        po.setRemark("备注");
        this.add(po);

        //demoBO.add();
        //Integer.parseInt("ssss");
        return false;
    }

}
