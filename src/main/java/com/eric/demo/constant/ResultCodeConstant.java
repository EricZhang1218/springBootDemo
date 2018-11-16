package com.eric.demo.constant;

public enum ResultCodeConstant {

    COMMON_SUCCESS("0101","请求成功"),
    COMMON_FAILED("0102","请求失败"),
       ;

    // 成员变量
    private String code;
    private String msg;



    private ResultCodeConstant(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
}
