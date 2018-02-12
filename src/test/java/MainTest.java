import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.springframework.util.CollectionUtils;

import java.util.*;

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


    /** 枚举处理分类 */
    protected static final List<String> CampaignInspectResultEnumDealMap = new ArrayList<String>(){{
       add("123");
        boolean add = add("123");
    }};

    public static void main(String[] args) {

       /* List<Integer> numbers = null;
        numbers.forEach(integer -> {
            System.out.println(integer);
        });*/


            String str = ",";
            System.out.println(str.indexOf(","));



/*
        Map map1 = new HashMap();
        map1.put("m1-1","11");
        map1.put("m1-2","12");

        Map map2 = new HashMap();
        map2.put("m2-1","21");
        map2.put("m2-2","22");

        List list = new ArrayList();
        list.add(map1);
        list.add(map2);

        String str = JSON.toJSONString(list);
        System.out.println(str);

        List<Map<String,Object>> rs = (List<Map<String, Object>>) JSON.parse("");
        System.out.println((rs==null));

        List<String> list = new ArrayList<String>();

        if(list == null || !list.contains("123")){
            System.out.println("123");
        }*/


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
