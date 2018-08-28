/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.middleware.es.api;

import com.google.common.collect.Lists;
import com.middleware.es.pojo.People;
import com.middleware.es.repository.IEsPeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shihong.msh
 * @version $Id: EsController.java, v 0.1 2018年08月28日 上午10:52 shihong.msh Exp $
 */
@RestController
@RequestMapping("/people")
public class EsController {

    @Autowired
    IEsPeopleRepository iEsPeopleRepository;

    /**
     * http://localhost:8080/myBoot/people/add
     * {
     *   "id": "1",
     *   "name":"name11",
     *   "country":"country",
     *   "age":"10",
     *   "date":"2018-01-01"
     * }
     * @param people
     * @return
     */
    @RequestMapping("/add")
    public People add(@RequestBody People people) {
        return iEsPeopleRepository.save(people);
    }

    /**
     * http://localhost:8080/myBoot/people/all
     * @return
     */
    @GetMapping("/all")
    public List<People> findAll(){
        Iterable<People> elements = iEsPeopleRepository.findAll();
        ArrayList<People> list = Lists.newArrayList(elements);
        return list;
    }


}