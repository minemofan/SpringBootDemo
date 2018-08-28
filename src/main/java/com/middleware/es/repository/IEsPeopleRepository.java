/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.middleware.es.repository;

import com.middleware.es.pojo.People;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ES People索引 资源层
 * @author shihong.msh
 * @version $Id: EsPeopleRepository.java, v 0.1 2018年08月27日 下午5:02 shihong.msh Exp $
 */
@Repository
public interface IEsPeopleRepository extends ElasticsearchRepository<People, Long> {
}