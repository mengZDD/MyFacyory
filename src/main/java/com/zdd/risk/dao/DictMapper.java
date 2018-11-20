package com.zdd.risk.dao;

import com.zdd.risk.bean.Dict;
import com.zdd.risk.bean.DictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DictMapper {
    int countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    @Select(value = "select * from dict where pid=#{pid}")
    Dict selectByPid(@Param("pid") int i);
}