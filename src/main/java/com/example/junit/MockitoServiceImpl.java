package com.example.junit;

import com.common.utils.LoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockitoServiceImpl implements IMockitoService {

    private Logger LOGGER = LoggerFactory.getLogger(MockitoServiceImpl.class);

    @Autowired
    private IMockioDao iMockioDao;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String getName(String id) {
        return iMockioDao.getName(",Service:"+ id);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<String> getList(String name) {
        LoggerUtils.info(LOGGER, "当前MockitoServiceImpl类getList，入参："+ name);
        name = ",Service:" + name;
        String rstr = iMockioDao.getName(name);
        LoggerUtils.info(LOGGER,"调用dao.getName返回值：{0}", rstr);
        List<String> rlist = iMockioDao.getList(rstr);
        return rlist;
    }

    /**
     * Description 验证方法被调用的次数
     * @param id
     * @return
     */
    @Override
    public boolean verifys(String id) {
        LoggerUtils.info(LOGGER, "当前MockitoServiceImpl类verifys，入参："+ id);
        List<String> list = null;
        String name = null;
        StringBuilder sb = new StringBuilder();

        //验证没有调用到的方法
        if(StringUtils.isBlank(id)){
            list = iMockioDao.getList(",toList:"+ id);
        }

        //验证调用一次的方法
        name = iMockioDao.getName(",toName:"+ id);

        //验证调用多次的方法
        sb.append(iMockioDao.getNames(",toNames1:"+ id));
        sb.append(iMockioDao.getNames(",toNames2:"+ id));
        sb.append(iMockioDao.getNames(",toNames3:"+ id));

        LoggerUtils.info(LOGGER,"调用dao.getName返回值" +
                ",\n list出参:{0} \n ,name出参:{1} \n ,names出参:{2}", list, name, sb.toString());
        return true;
    }


    /**
     *
     * @param name
     * @return
     */
    private String getPriName(String name){
        LoggerUtils.info(LOGGER, "【私有方法】当前MockitoServiceImpl类getPriName，入参：{0}", name);
        name = ",ProName:" + name;
        return name;
    }


    /**
     *
     * @param name
     * @return
     */
    private String getPriNameAndTran(String name){
        LoggerUtils.info(LOGGER, "【私有方法】当前MockitoServiceImpl类getPriName，入参：{0}", name);
        String rstr = iMockioDao.getName(",getPriNameAndTran:"+ name);
        name = ",getPriNameAndTran:" + rstr;
        LoggerUtils.info(LOGGER, "【私有方法】当前MockitoServiceImpl类getPriName，出参：{0}", name);
        return name;
    }






    //=============================     getter  setter     ==================================
    /**
     *
     * @param iMockioDao
     */
    public void setiMockioDao(IMockioDao iMockioDao){
        this.iMockioDao = iMockioDao;
    }

}
