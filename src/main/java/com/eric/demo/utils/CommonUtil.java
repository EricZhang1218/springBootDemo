package com.eric.demo.utils;

import com.eric.demo.constant.ResultCodeConstant;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
    public static Map<String, Object> resultMap(int status, String code, String msg, Object data) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", status);
        m.put("code", code == null ? "" : code);
        m.put("msg", msg == null ? "" : msg);
        m.put("data", data == null ? "" : data);
        return m;
    }

    public static Map<String, Object> resultMap(int status, ResultCodeConstant c, Object data) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", status);
        m.put("code", c.getCode());
        m.put("msg", c.getMsg());
        m.put("data", data == null ? "" : data);
        return m;
    }
}
