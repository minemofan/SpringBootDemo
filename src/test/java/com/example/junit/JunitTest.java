package com.example.junit;

import com.common.utils.LoggerUtils;
import com.core.controller.TestUserController;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Titel    单元测试
 * @Description
 *   1、@RunWith(SpringJUnit4ClassRunner.class)
 *          SpringJUnit支持，由此引入Spring-Test框架支持！PowerMockRunner.class
 *   2、@SpringBootTest
 *          boot1.4版本以后支持，1.4以前要是用"3"。
 *   3、@SpringApplicationConfiguration(classes = SpringBootDemoApplication.class)  + @WebAppConfiguration
 *   3-1、SpringApplicationConfiguration：指定我们SpringBoot工程的Application启动类
 *   3-2、WebAppConfiguration: 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
 * @author  mofan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JunitTest {

    private Logger LOGGER = LoggerFactory.getLogger(JunitTest.class);

    @Autowired
    private IMockitoService mockitoService;

    /**
     * mock了service之后，运行时将不会运行到service类中 */
    @Mock
    private MockitoServiceImpl mockitoServiceImplMock;

    @Mock
    private IMockioDao iMockioDao;

    private MockitoServiceImpl mockitoServiceImplUnMock;

    @Before
    public void setUp() {
        mockitoServiceImplUnMock = new MockitoServiceImpl();
        mockitoServiceImplUnMock.setiMockioDao(iMockioDao);
    }

    /**
     * Description 连通性、SQL测试
     */
    @Test
    public void testHelloWorld(){
        LoggerUtils.info(LOGGER,"连通性、SQL测试      Begin！");
        mockitoService.getName("1");

        mockitoService.getList("name");
        LoggerUtils.info(LOGGER,"连通性、SQL测试      End!");
    }

    /**
     * Description  单元测试
     */
    @Test
    public void testGetNameMock(){
        LoggerUtils.info(LOGGER, "单元测试      Begin!");

        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";

        //2.mock返回值,不管传什么均返回123。
        Mockito.when(mockitoServiceImplMock.getName(Mockito.anyString())).thenReturn(mockResult);

        //3.调用方法
        String result = mockitoServiceImplMock.getName(param);
        LoggerUtils.info(LOGGER, "result:{0}", result);

        //4。验证返回值
        Assert.assertEquals(mockResult, result);

        LoggerUtils.info(LOGGER,"单元测试      End!");
    }




    /**
     * Title    不进入getList()方法主体
     * Description  MOCK多层方法调用，mock DAO无效
     */
    @Test
    public void testGetList1(){
        LoggerUtils.info(LOGGER, "单元测试      Begin!");

        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";

        List<String> mockList = new ArrayList<>();
        mockList.add("-壹-");
        mockList.add("-贰-");
        mockList.add("-叄-");


        //2.mock返回值
        Mockito.when(iMockioDao.getName(Mockito.anyString())).thenReturn(mockResult);
        Mockito.when(mockitoServiceImplMock.getList(Mockito.anyString())).thenReturn(mockList);

        //3.调用方法，验证当使用mockito.when之后，下方调用时，根本不会执行到代码块当中
        List<String> list = mockitoServiceImplMock.getList(param);

        //4.验证返回值
        Assert.assertEquals(mockList, list);

        LoggerUtils.info(LOGGER,"单元测试      End!");
    }


    /**
     * Title    进去getList()方法主体
     * Description
     */
    @Test
    public void testGetList2(){
        LoggerUtils.info(LOGGER, "单元测试-无mock      Begin!");

        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";

        List<String> mockList = new ArrayList<>();
        mockList.add("-壹-");
        mockList.add("-贰-");
        mockList.add("-叄-");


        //2.mock返回值
        Mockito.when(iMockioDao.getName(Mockito.anyString())).thenReturn(mockResult);
        Mockito.when(iMockioDao.getList(Mockito.anyString())).thenReturn(mockList);

        //3.调用方法，验证当使用mockito.when之后，下方调用时，根本不会执行到代码块当中
        List<String> list = mockitoServiceImplUnMock.getList(param);

        //4.验证返回值
        Assert.assertEquals(mockList, list);

        LoggerUtils.info(LOGGER,"单元测试-无mock      End!");
    }


    /**
     * Description 【单测私有方法不能用Mock】私有方法内部无调用其他类的
     */
    @Test
    public void testGetPriName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LoggerUtils.info(LOGGER, "单元测试-无mock      Begin!");
        //1.构造入参数据
        String param = "壹贰叄";


        //2.方法调用
        Class[] parameterTypes = {String.class};           //入参类型
        Object[] parameters = {param};     //入参

        Method method = mockitoServiceImplUnMock.getClass().getDeclaredMethod("getPriName", String.class);
        method.setAccessible(true);                                             // 允许处理私有方法
        String rstr = (String) method.invoke(mockitoServiceImplUnMock, param);
        method.setAccessible(false);

        //3.验证返回值
        Assert.assertEquals(",ProName:"+param, rstr);
        LoggerUtils.info(LOGGER, "单元测试-无mock      End!");
    }


    /**
     * Description 【单测私有方法不能用Mock】私有方法内部无调用其他类的
     */
    @Test
    public void testGetPriNameAndTran() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LoggerUtils.info(LOGGER, "单元测试-无mock      Begin!");
        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";

        //2.方法调用
        Class[] parameterTypes = {String.class};           //入参类型
        Object[] parameters = {param};                      //入参

        //3.Mock返回值
        Mockito.when(iMockioDao.getName(Mockito.anyString())).thenReturn(mockResult);

        //4.调用
        Method method = mockitoServiceImplUnMock.getClass().getDeclaredMethod("getPriNameAndTran", parameterTypes);
        method.setAccessible(true);                                             // 允许处理私有方法
        String rstr = (String) method.invoke(mockitoServiceImplUnMock, parameters);
        method.setAccessible(false);

        //5.验证返回值
        Assert.assertEquals(",getPriNameAndTran:"+ mockResult, rstr);
        LoggerUtils.info(LOGGER, "单元测试-无mock      End!");
    }

    /**
     * Description
     */
    @Test
    public void testVerifys(){
        LoggerUtils.info(LOGGER, "单元测试-校验调用次数      Begin!");
        //1.构造入参数据
        String param = "壹贰叄";

        String mockResult = "123";
        List<String> mockList = new ArrayList<>();
        mockList.add("-壹-");
        mockList.add("-贰-");
        mockList.add("-叄-");


        //2.方法调用
        Class[] parameterTypes = {String.class};           //入参类型
        Object[] parameters = {param};                      //入参

        //3.Mock返回值
        Mockito.when(iMockioDao.getName(Mockito.anyString())).thenReturn(mockResult);
        Mockito.when(iMockioDao.getList(Mockito.anyString())).thenReturn(mockList);
        Mockito.when(iMockioDao.getNames(Mockito.anyString())).thenReturn("123").thenReturn("456");

        //4.真实调用
        boolean flag = mockitoServiceImplUnMock.verifys(param);

        //5.验证结果
        Assert.assertTrue(flag);

        //验证-为调用过此方法
        Mockito.verify(iMockioDao, Mockito.never()).getList(Mockito.anyString());

        //验证-调用了一次此方法
        Mockito.verify(iMockioDao, Mockito.times(1)).getName(Mockito.anyString());
        Mockito.verify(iMockioDao).getName(Mockito.any(String.class));

        //验证-调用了多次此方法
        Mockito.verify(iMockioDao, Mockito.times(3)).getNames(Mockito.anyString());

        LoggerUtils.info(LOGGER, "单元测试-校验调用次数      End!");
    }

    /**
     * Description 验证异常
     * 构造mock的函数抛出异常，当然我们可以在testng中设置expectedExceptions以显示声明会抛出指定类型的异常，这样该条case执行的时候就会成功
     */
    @Test
    public void testGetNameToException(){
        LoggerUtils.info(LOGGER, "单元测试      Begin!");

        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";

        //2.mock返回值,不管传什么均返回123。
        Mockito.when(mockitoServiceImplMock.getName(Mockito.anyString())).thenThrow(new RuntimeException("运行时异常"));

        //3.调用方法
        try{
            String result = mockitoServiceImplMock.getName(param);
            LoggerUtils.info(LOGGER, "result:{0}", result);
        }catch (Exception e){
            LoggerUtils.info(LOGGER,"出错了，日志：{0}。", e);
        }
        LoggerUtils.info(LOGGER,"单元测试      End!");
    }


    /**
     * Titel  自定义返回值（Answer）
     * Description  对mock对象的方法进行调用预期的设定，可以通过thenReturn()来指定返回值，thenThrow()指定返回时所抛异常
     *  ，通常来说这两个方法足以应对一般的需求。但有时我们需要自定义方法执行的返回结果，Answer接口就是满足这样的需求而存在的。
     */
    @Test
    public void testGetNameToAnswer(){
        LoggerUtils.info(LOGGER, "单元测试      Begin!");

        //1.构造入参数据
        String param = "壹贰叄";
        String mockResult = "123";
        String mockResultByAnswer = "yzt";

        //2.mock返回值,若传"壹账通"则返回"yzt",否则返回"123"。
        Mockito.when(mockitoServiceImplMock.getName(Mockito.anyString())).thenAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                String str = (String)args[0];
                if(param.equals(str)){
                    return mockResultByAnswer;
                } else {
                   // throw new RuntimeException();
                    return mockResult;
                }
            }
        });

        //3.调用方法
        //调用一
        String result1 = mockitoServiceImplMock.getName(param);
        LoggerUtils.info(LOGGER, "result1:{0}", result1);

        //调用二
        String result2 = mockitoServiceImplMock.getName(param + "123");
        LoggerUtils.info(LOGGER, "result2:{0}", result2);

        //4.验证结果
        Assert.assertEquals(mockResultByAnswer, result1);
        Assert.assertEquals(mockResult, result2);

        LoggerUtils.info(LOGGER,"单元测试      End!");
    }

    /**
     * Descrption
     */
    @Test
    public void testGetListToAnswer(){
        LoggerUtils.info(LOGGER, "单元测试      Begin!");

        //1.构造入参
        String param = "壹贰叄";

        List<String> rlist1 = Lists.newArrayList();
        rlist1.add("壹");
        rlist1.add("贰");
        rlist1.add("叄");

        List<String> rlist2 = Lists.newArrayList();
        rlist2.add("1");

        //2.mock返回值
        Mockito.when(mockitoServiceImplMock.getList(Mockito.anyString())).thenAnswer(new Answer<Object>() {
            @Override
            public List<String> answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                String str = (String)args[0];
                if(param.equals(str)){
                    rlist1.add("return1");
                    return rlist1;
                }else{
                    rlist2.add("return2");
                    return rlist2;
                }
            }
        });

        //3.调用服务
        //调用一
        List<String> result1 = mockitoServiceImplMock.getList(param);
        LoggerUtils.info(LOGGER, "result1:{0}", result1);

        //调用二
        List<String> result2 = mockitoServiceImplMock.getList(param + "123");
        LoggerUtils.info(LOGGER, "result2:{0}", result2);

        Assert.assertEquals(4, result1.size());
        Assert.assertEquals(2, result2.size());

        LoggerUtils.info(LOGGER,"单元测试      End!");
    }

}
