package com.zdd.risk.service;

import com.zdd.risk.bean.BlacklistInfo;

import java.util.List;

/**
 * Created by 孟庆合 on 2018/11/7.
 */
public interface BlackListInfoService {
    Integer selectCount(String idcardNo, String tel, String place);

    void add(BlacklistInfo blacklistInfo);

    List<BlacklistInfo> select1BlackByLink(String linkTel);

    List<BlacklistInfo> selectByGrade2(String linkTel);

    List<BlacklistInfo> selectByAddress1(String place);

    List<BlacklistInfo> selectByTel(String tel);

    List<BlacklistInfo> selectByIdcardNo(String idcardNo);

    List<BlacklistInfo> selectByAddress(String place);
}
