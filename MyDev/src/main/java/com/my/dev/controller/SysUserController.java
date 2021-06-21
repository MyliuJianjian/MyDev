package com.my.dev.controller;

import com.my.dev.entity.userinfo.SysUserEntity;
import com.my.dev.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月15日19:13:55$
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/findUser")
    public Object findUser(){
        return sysUserService.findUserInfo(1);
    }
    @PostMapping("/saveUser")
    public Object saveUser(@RequestBody SysUserEntity user){
        return sysUserService.saveUserInfo(user);
    }
}
