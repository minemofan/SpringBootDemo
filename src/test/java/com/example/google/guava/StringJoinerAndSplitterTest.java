package com.example.google.guava;

import com.example.junit.JunitTest;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description Joiner、Splitter 字符串处理：分割，连接，填充
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StringJoinerAndSplitterTest {

    private Logger LOGGER = LoggerFactory.getLogger(StringJoinerAndSplitterTest.class);

    private static void LogInfo(Object msg){
        System.out.println(msg);
    }

    private static void splitLine() {
        System.out.println("==================================================================================== 华丽的分割线 ！");
    }




    /**
     *  */
    @Test
    public void joinerTest(){
        splitLine();
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        Joiner joiner = Joiner.on(",").skipNulls();
        LogInfo(joiner.join(list));
    }

    /**
     *  */
    @Test
    public void splitterTest(){
        splitLine();
        String str = "fasdga, , fasgasd, fasdgas";
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        List<String> stringList = splitter.splitToList(str);
        for (String s : stringList) {
            LogInfo(s);
        }
    }

    /**
     * 测试当str为""时 */
    @Test
    public void splitterTest2(){
        splitLine();
        String str = "";
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        List<String> stringList = splitter.splitToList(str);
        LogInfo(stringList);
    }

    /**
     * 测试当str为""时 出现异常 */
    @Test(expected = NullPointerException.class)
    public void splitterTest3(){
        splitLine();
        String str = null;
        Splitter splitter = Splitter.on(",").omitEmptyStrings().trimResults();
        List<String> stringList = splitter.splitToList(str);
        LogInfo(stringList);

    }
}
