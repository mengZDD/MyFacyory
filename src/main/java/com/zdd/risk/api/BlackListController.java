package com.zdd.risk.api;

import com.alibaba.fastjson.JSONObject;
import com.zdd.risk.bean.BlacklistInfo;
import com.zdd.risk.bean.BlacklistInfoExample;
import com.zdd.risk.dao.BlacklistInfoDAO;
import com.zdd.risk.service.BlackListInfoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by 孟庆合 on 2018/11/7.
 */

@RestController
public class BlackListController {


    private static final Logger log = LoggerFactory.getLogger(BlackListController.class);
    @Autowired
    private BlacklistInfoDAO blacklistInfoDAO;




    //查询返回的重复的数量

    /**
     *
     * 这个写完了
     * @param idcardNo
     * @param tel
     * @param address
     * @return
     */
    @RequestMapping(value = "count",method = RequestMethod.POST)
    public Map<String,Object> getBlackCount(String idcardNo,String tel,String address) {
        int i = blacklistInfoDAO.selectCount(idcardNo, tel, address);
        Map<String,Object> map=new HashMap<>();
        map.put("aa",i);
        return map;
       //return  blackListInfoService.selectCount(idcardNo,tel,place);
    }




    //往黑名单里面添加数据
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    /**
     *
     * 这个完事了
     */
    public void AddBlackList(String userid,String oauthuid,String tel,String name,String idcardNo,String address,String ymdhms,String grade) {
        BlacklistInfo sb=new BlacklistInfo();
        sb.setUserid(userid);
        sb.setTel(tel);
        sb.setOauthuid(oauthuid);
        sb.setName(name);
        sb.setIdcardNo(idcardNo);
        sb.setAddress(address);
        sb.setYmdhms(ymdhms);
        sb.setGrade(grade);
        System.out.println("走了一遍添加黑名单的这个方法");
        blacklistInfoDAO.insert(sb);
    }




    /**
     *
     * 这个完事了
     * @param linkTel
     * @return
     */
    //内部匹配紧急联系人在我司为一级黑名单，先查询所有的紧急联系人的号码
@RequestMapping(value = "/select",method =RequestMethod.POST )
    public List<BlacklistInfo>findGrade2( String linkTel) {
    BlacklistInfoExample black1 = new BlacklistInfoExample();
    black1.createCriteria().andTelEqualTo(linkTel).andGradeEqualTo("1");
    return blacklistInfoDAO.selectByExample(black1);

}




    //查询的是逾期的紧急联系人的方法
    @RequestMapping(value = "/cha",method = RequestMethod.POST)
    public List<BlacklistInfo> selectByGrade2(String linkTel){
        return blacklistInfoDAO.selectByGrade2(linkTel);
    }




    //内部匹配收货地址在一级的黑名单当中
    @RequestMapping(value = "/address1",method = RequestMethod.POST)
    public List<BlacklistInfo> selectByAddress1(String place){
        BlacklistInfoExample be = new BlacklistInfoExample();
        be.createCriteria().andAddressEqualTo(place).andGradeEqualTo("1");
       return blacklistInfoDAO.selectByExample(be);
    }





    //通过手机号查询黑名单
    @RequestMapping(value = "/tel",method = RequestMethod.POST)
    public List<BlacklistInfo> selectByTel(String tel){
        BlacklistInfoExample example = new BlacklistInfoExample();
        example.createCriteria().andTelEqualTo(tel);
        return blacklistInfoDAO.selectByExample(example);
    }



    //通过身份证号查询黑名单
    @RequestMapping(value = "/idcardNo",method = RequestMethod.POST)
    public List<BlacklistInfo> selectByIdcardNo(String idcardNo){
        BlacklistInfoExample sb = new BlacklistInfoExample();
        sb.createCriteria().andIdcardNoEqualTo(idcardNo);
        return  blacklistInfoDAO.selectByExample(sb);
    }




    //通过用户的地址来查询
    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public List<BlacklistInfo> selectByAddress(String place){

        log.info("通过收货地址来查询传入的参数是"+place);
        BlacklistInfoExample black = new BlacklistInfoExample();
        black.createCriteria().andAddressEqualTo(place);
        return  blacklistInfoDAO.selectByExample(black);
    }



    //用来洗白的接口
    @RequestMapping(value = "/white",method =RequestMethod.POST)
    public void white(String userId){

        log.info("洗白接口传入的参数是"+userId);
       blacklistInfoDAO.selectByUserId(userId);
    }





    @RequestMapping(value = "/select2",method = RequestMethod.GET)
    public List<BlacklistInfo> selectAll2(){

        log.info("查询的是所有的二级黑名单的成员");
        return blacklistInfoDAO.selectAll2();
    }
}