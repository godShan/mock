package com.zbjk.creditfactory.mock.common.constant;

import java.util.Objects;

/**
 * Created by DELL on 2017/8/4.
 * @author weiyushan
 */
public enum ResponseCode {

    // 通用返回码
    CODE_SUCCESS(100000, "处理成功"),
    CODE_ERROR(100001, "处理失败"),
    CODE_SYSTEM_ERROR(100002, "系统错误"),

    //登录返回码
    LOGIN_UUID_CODE_SUCCESS(000000, "获取秘钥成功"),
    LOGIN_UUID_CODE_ERROR(000001, "获取秘钥失败"),

    LOGIN_CODE_SUCCESS(000002, "登录成功"),
    LOGIN_CODE_ERROR(000003, "登录失败"),

    SEND_MSG_CODE_ERROR(000004, "短信发送失败"),
    SEND_EMAIL_CODE_ERROR(000005, "邮箱发送失败"),
    SEND_WECHAT_CODE_ERROR(000006, "微信发送失败");

    // 业务返回码

    private Integer code;
    private String msg;
    private boolean success;

    ResponseCode(int code, String msg, boolean success) {
        this.setCode(code);
        this.setMsg(msg);
        this.setSuccess(success);
    }

    ResponseCode(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        this.setSuccess(false);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        success = (Objects.equals(code, CODE_SUCCESS.getCode()));
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
