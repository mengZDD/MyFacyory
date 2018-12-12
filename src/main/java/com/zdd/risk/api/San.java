package com.zdd.risk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zdd.risk.bean.Certification;
import com.zdd.risk.bean.CertificationExample;
import com.zdd.risk.dao.ICertificationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 孟庆合 on 2018/11/30.
 */
@RestController
public class San {

    private static final Logger log = LoggerFactory.getLogger(San.class);
    @Autowired
    private ICertificationDAO iCertificationDAO;
    @RequestMapping(value = "/wang",method = RequestMethod.POST)
    public String findByIdacrdNo5(@RequestBody String parm){

        log.info("在网接受到的参数是:"+parm);
        JSONObject jsonObject = JSON.parseObject(parm);

         Certification  aa=iCertificationDAO.findByIdcardNo5(jsonObject.getString("idcardNo"));

         log.info("返回的结果是"+JSON.toJSONString(aa));
        return JSON.toJSONString(aa);
    }
    @RequestMapping(value = "/san",method = RequestMethod.POST)
    public String findByIdacrdNo2(@RequestBody String parm){

        log.info("三要素认证接受到的参数是:"+parm);

        JSONObject jsonObject = JSON.parseObject(parm);

       Certification bb=iCertificationDAO.findByIdcardNo2(jsonObject.getString("idcardNo"));

        log.info("返回的结果是"+JSON.toJSONString(bb));
        return JSON.toJSONString(bb);
    }

    @RequestMapping(value = "/fen",method = RequestMethod.POST)
    public String findByIdacrdNo9(@RequestBody String parm){

        log.info("芝麻分接受到的参数是:"+parm);
        JSONObject jsonObject = JSON.parseObject(parm);

        Certification cc=iCertificationDAO.findByIdcardNo9(jsonObject.getString("idcardNo"));

        log.info("返回的结果是"+JSON.toJSONString(cc));
        return JSON.toJSONString(cc);
    }

}
