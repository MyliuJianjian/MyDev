package com.my.dev.service.impl;

import com.my.common.ConstantsUtils;
import com.my.dev.JpaRepository.SysUserRepository;
import com.my.dev.entity.userinfo.SysUserEntity;
import com.my.dev.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月3日15:15:44$
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUserEntity findUserInfo(Integer id){
        return sysUserRepository.findById(id).get();
    }

    public SysUserEntity saveUserInfo(SysUserEntity user){
        return sysUserRepository.save(user);
    }
}
