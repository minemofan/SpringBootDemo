package common.javacore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/22.
 * RunWith：SpringJUnit支持，由此引入Spring-Test框架支持！
 * SpringApplicationConfiguration   指定我们SpringBoot工程的Application启动类
 * WebAppConfiguration  由于是Web项目，Junit需要模拟ServletContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsTerminatedTest {

    //@Autowired
   // private IsTerminated isTerminated;

    /**
     *
     */
    @Test
    public void ShutDownTest(){
        System.out.println("------------------------begin ShutDown!");
    //    System.out.println("isTerminated:"+ isTerminated);
        System.out.println("------------------------End ShutDown!");
    }

    /**
     *
     */
    public void ShutDownNowTest(){

    }
}
