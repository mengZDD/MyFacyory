package com.zdd.risk.api;

import com.zdd.risk.bean.Dict;
import com.zdd.risk.bean.DictExample;
import com.zdd.risk.dao.DictMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孟庆合 on 2018/11/19.
 */
@RestController
public class Button {

    private static final Logger log = LoggerFactory.getLogger(Button.class);
    @Autowired
    private DictMapper dictMapper;

    @RequestMapping(value = "/button",method = RequestMethod.POST)
    public Map<String,String> selectByPid(String i){
        log.info("控制开关传入的参数是"+i);

    int i1 = Integer.parseInt(i);

    DictExample h=new DictExample();

    h.createCriteria().andPidEqualTo(i1);

    List<Dict> dicts = dictMapper.selectByExample(h);

    Map<String,String> map=new HashMap<>();
        map.put("button",dicts.get(0).getName());
        return map;
    }




}
