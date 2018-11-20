package com.zdd.risk.service.impl;

import com.zdd.risk.bean.BlacklistInfo;
import com.zdd.risk.bean.BlacklistInfoExample;
import com.zdd.risk.dao.BlacklistInfoDAO;
import com.zdd.risk.service.BlackListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by 孟庆合 on 2018/11/7.
 */
@Service
@Component
public class BlackListInfoServiceImpl implements BlackListInfoService {
    @Autowired
    private BlacklistInfoDAO blacklistInfoDAO;

    @Override
    public Integer selectCount(String idcardNo, String tel, String place) {
        return blacklistInfoDAO.selectCount(idcardNo,tel,place);
    }

    @Override
    public void add(BlacklistInfo blacklistInfo) {

        blacklistInfoDAO.insert(blacklistInfo);
    }

    @Override
    public List<BlacklistInfo> select1BlackByLink(String linkTel) {

        BlacklistInfoExample black1 = new BlacklistInfoExample();

        black1.createCriteria().andTelEqualTo(linkTel).andGradeEqualTo("1");

        return blacklistInfoDAO.selectByExample(black1);
    }

    @Override
    public List<BlacklistInfo> selectByGrade2(String linkTel) {
       return  blacklistInfoDAO.selectByGrade2(linkTel);
    }

    @Override
    public List<BlacklistInfo> selectByAddress1(String place) {
        BlacklistInfoExample be = new BlacklistInfoExample();

        be.createCriteria().andAddressEqualTo(place).andGradeEqualTo("1");

        return  blacklistInfoDAO.selectByExample(be);
    }

    @Override
    public List<BlacklistInfo> selectByTel(String tel) {
        BlacklistInfoExample black1 = new BlacklistInfoExample();

        black1.createCriteria().andTelEqualTo(tel);

        System.out.println(blacklistInfoDAO.selectByExample(black1));
       return  blacklistInfoDAO.selectByExample(black1);
    }

    @Override
    public List<BlacklistInfo> selectByIdcardNo(String idcardNo) {
        BlacklistInfoExample sb = new BlacklistInfoExample();
        sb.createCriteria().andIdcardNoEqualTo(idcardNo);

      return blacklistInfoDAO.selectByExample(sb);
    }

    @Override
    public List<BlacklistInfo> selectByAddress(String place) {
        BlacklistInfoExample black = new BlacklistInfoExample();

        black.createCriteria().andAddressEqualTo(place);

       return  blacklistInfoDAO.selectByExample(black);
    }
}
