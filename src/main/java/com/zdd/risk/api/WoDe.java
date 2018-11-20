package com.zdd.risk.api;

import com.zdd.risk.bean.ResponseResult;
import com.zdd.risk.utils.HttpConnectionManager;

/**
 * Created by 孟庆合 on 2018/11/8.
 */
public class WoDe {

    public static void main(String[] args) {

        ResponseResult responseResult = HttpConnectionManager.doGet("localhost:8080/queryUserList");

        Object data = responseResult.getData();
        System.out.println(data);
    }
}
