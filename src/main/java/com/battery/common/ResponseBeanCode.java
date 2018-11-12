package com.battery.common;

/**
 * Created by ellen on 2018/11/1.
 * ResponseBean返回码
 */
public class    ResponseBeanCode {

    //请求成功
    public static final int SUCCESS = 2000 ;

    //未登录
    public static final int NO_LOGIN = 4003 ;

    //未绑定手机
    public static final int NO_BOUND = 4002 ;

    //未设置密码
    public static final int NO_SET_PASSWORD = 4003 ;

    //没有权限
    public static final int NO_POWER = 4001;

    //请求失败
    public static final int ERROR = 5000 ;

    public static final int EXCEPTION = 4005;

    public static final int WARN = 2001;
}
