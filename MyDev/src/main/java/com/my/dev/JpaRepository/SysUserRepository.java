package com.my.dev.JpaRepository;

import com.my.dev.entity.userinfo.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserRepository extends JpaSpecificationExecutor<SysUserEntity>, JpaRepository<SysUserEntity, Integer>{
}
