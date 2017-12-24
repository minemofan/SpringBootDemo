package com.core.dao.mapper;

import com.core.pojo.dto.TestUserDTO;
import com.core.pojo.po.TestUserPO;
import com.core.pojo.vo.DemoVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ITestUserMapper {

    void insert(TestUserPO po);

    List<TestUserDTO> queryAll();

    List<TestUserDTO> queryAllById(Integer id);

    List<TestUserDTO> queryAllByMap(Map<String, Object> param);

    void updateById(DemoVO vo);

    void deleteByName(String name);

    List<TestUserDTO> queryByLimit(Map<String, Object> param);

}
