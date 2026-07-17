package com.hoops.serviceorder.config;

import lombok.Data;

@Data
public class R {
    private String code;
    private String msg;
    private Object data;

    public static R ok(String code){
        return new R(code);
    }

    public static R error(String code,String msg,Object data){
        return new R(code,msg,data);
    }

    public R(String code) {
        this.code = code;
    }

    public R(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
