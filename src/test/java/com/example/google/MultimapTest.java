package com.example.google;

import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class MultimapTest {


    private long id;

    private String name;

    public static final String ALL = "*";

    public static void main(String[] args) {

        Map<String, String> map = null;

        System.out.println(Splitter.on(",").splitToList("1"));


        /*
        Multimap<String, MultimapTest> resultProcessors = init();

        Set<MultimapTest> needProcessor = new HashSet<MultimapTest>();
        Collection<MultimapTest> processors = resultProcessors.get("name001");
        if (!CollectionUtils.isEmpty(processors)) {
            System.out.println("no.1:"+ processors);
            needProcessor.addAll(processors);
            System.out.println("no.2:"+ processors);
        }

        Collection<MultimapTest> allProcessors = resultProcessors.get("*");
        if (!CollectionUtils.isEmpty(allProcessors)) {
            System.out.println("no.3:"+ processors);
            needProcessor.addAll(allProcessors);
            System.out.println("no.4:"+ processors);
        }*/


        /*
        Multimap<String, Set<MultimapTest>> resultProcessors2 = init2();

        Set<MultimapTest> needProcessor2 = new HashSet<MultimapTest>();
        Collection<Set<MultimapTest>> processors2 = resultProcessors2.get("name001");
        if (!CollectionUtils.isEmpty(processors2)) {
            System.out.println("no2.1:"+ processors2);
            needProcessor2.addAll(processors2);         ????????
            System.out.println("no2.2:"+ processors2);
        }

        Collection<Set<MultimapTest>> allProcessors2 = resultProcessors2.get(MultimapTest.ALL);
        if (!CollectionUtils.isEmpty(allProcessors2)) {
            System.out.println("no2.3:"+ processors2);
            needProcessor2.addAll(allProcessors2);      ???????????
            System.out.println("no2.4:"+ processors2);
        }*/

    }

    public static Multimap<String, MultimapTest> init(){
        Multimap<String, MultimapTest> multimap = ArrayListMultimap.create();

        Set<MultimapTest> set = new HashSet<>();

        MultimapTest test1 = new MultimapTest();
        test1.setId(001);
        test1.setName("name001");

        MultimapTest test2 = new MultimapTest();
        test2.setId(002);
        test2.setName("name002");

        set.add(test1);
        set.add(test2);

        multimap.put("name001",test1);
        multimap.put("name002",test2);
        return multimap;
    }


    public static Multimap<String,  Set<MultimapTest>> init2(){
        Multimap<String, Set<MultimapTest>> multimap = ArrayListMultimap.create();

        Set<MultimapTest> set = new HashSet<>();

        MultimapTest test1 = new MultimapTest();
        test1.setId(001);
        test1.setName("name001");

        MultimapTest test2 = new MultimapTest();
        test2.setId(002);
        test2.setName("name002");

        set.add(test1);
        set.add(test2);

        multimap.put("name003",set);
        return multimap;
    }

    //-----------------------------------  setter getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}