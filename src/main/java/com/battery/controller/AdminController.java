package com.battery.controller;

import com.battery.bean.ResponseBean;
import com.battery.entity.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ellen
 * @version 1.0
 * @date 2018/11/1
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/login")
    public ResponseBean login(){
        Admin admin = new Admin();
        admin.setAdminName("admin");

        return ResponseBean.createSuccess().addData("admin",admin);
    }

}
