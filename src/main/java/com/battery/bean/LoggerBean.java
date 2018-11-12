package com.battery.bean;

import org.apache.log4j.Logger;


/**
 * 自定义日志输出
 * Created by ellen on 2018/11/1
 */
public class LoggerBean {

    /**
     * 控制台输出
     */
    public static final Logger CONSOLE = Logger.getLogger("Console");

    /**
     * 系统日志
     */
    public static final Logger SYSTEM = Logger.getLogger("system");

    /**
     * 后台用户登录日志
     */
    public static final Logger LOGIN = Logger.getLogger("login");

    /**
     * 后台用户注销日志
     */
    public static final Logger LOGOUT = Logger.getLogger("logout");

    /**
     * 定时任务日志
     */
    public static final Logger TASK = Logger.getLogger("task");
}