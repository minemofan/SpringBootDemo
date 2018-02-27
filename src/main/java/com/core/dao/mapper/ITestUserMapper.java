package com.core.dao.mapper;

import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface ITestUserMapper {

    void insert(TestUserPO po);

    List<TestUserDTO> queryAll();

    List<TestUserDTO> queryAllById(Integer id);

    List<TestUserDTO> queryAllByMap(Map<String, Object> param);

    int updateById(TestUserPO vo);

    int deleteByName(String name);

    List<TestUserDTO> queryByLimit(Map<String, Object> param);

}
