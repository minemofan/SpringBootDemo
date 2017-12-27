import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 * Test：    把一个方法标记为测试方法
 * Before：  每一个测试方法执行前自动调用一次
 * After：   每一个测试方法执行完自动调用一次
 * BeforeClass： 所有测试方法执行前执行一次，在测试类还没有实例化就已经被加载
 *      ，所以用static修饰
 * AfterClass：所有测试方法执行完执行一次，在测试类还没有实例化就已经被加载
 *      ，所以用static修饰
 * Ignore：暂不执行该测试方法
 */
public class MainTest {

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        MainTest.subListTest();
    }


    private static void compareListTest(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");

        System.out.println(list1.containsAll(list2));
        System.out.println(list2.containsAll(list1));
    }


    private static void subListTest(){
        List<String> list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        List<String> lili = list.subList(1,3);
        System.out.println(lili.toString());

    }


}
