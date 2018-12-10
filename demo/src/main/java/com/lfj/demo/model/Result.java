package com.lfj.demo.model;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/10/25.
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -7849722266978163909L;

    private int code;
    private String msg;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
