package com.eric.demo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    protected <T> T toObject(String jsonCommand, Class<T> class1) {
        ObjectMapper jack = new ObjectMapper();
        try {

            T obj = JSON.parseObject(JSON.toJSONString(toMap(jsonCommand)),class1);
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected Map<Object, Object> toMap(String jsonCommand) {
        Map<Object,Object> map  = new HashMap<>();
        try {
            //map= (Map) JSON.parseObject(AESUtils.decode(jsonCommand));
            map= (Map) JSON.parseObject(jsonCommand);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
