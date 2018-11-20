package com.zdd.risk.dao;


import com.zdd.risk.bean.BlacklistInfo;
import com.zdd.risk.bean.BlacklistInfoExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlacklistInfoDAO {
    int countByExample(BlacklistInfoExample example);

    int deleteByExample(BlacklistInfoExample example);

    int deleteByPrimaryKey(Long seqid);

    int insert(BlacklistInfo record);

    int insertSelective(BlacklistInfo record);

    List<BlacklistInfo> selectByExample(BlacklistInfoExample example);

    BlacklistInfo selectByPrimaryKey(Long seqid);

    int updateByExampleSelective(@Param("record") BlacklistInfo record, @Param("example") BlacklistInfoExample example);

    int updateByExample(@Param("record") BlacklistInfo record, @Param("example") BlacklistInfoExample example);

    int updateByPrimaryKeySelective(BlacklistInfo record);

    int updateByPrimaryKey(BlacklistInfo record);

    @Select(value = "select count(*) from blacklist_info where idcard_no=#{idcardNo} or tel=#{tel} or address=#{place}")
    int selectCount(@Param("idcardNo") String idcardNo, @Param("tel") String tel, @Param("place") String place);

    @Select(value = "select * from blacklist_info where tel=#{linktel} and grade='2'")
    List<BlacklistInfo> selectByGrade2(@Param("linktel") String linktel);

    @Delete(value = "delete from blacklist_info where userid=#{userid}")
    void white(@Param("userid") String userId);

    @Select(value = "select * from blacklist_info where userid=#{userid}")
    BlacklistInfo selectByUserId(@Param("userid") String userId);

    @Select(value = "select * from blacklist_info where grade ='2' ")
    List<BlacklistInfo> selectAll2();
}