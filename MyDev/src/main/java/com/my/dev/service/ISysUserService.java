package com.my.dev.service;

import com.my.dev.entity.userinfo.SysUserEntity;

public interface ISysUserService {
    SysUserEntity findUserInfo(Integer id);
    SysUserEntity saveUserInfo(SysUserEntity user);
}
