package com.my.dev.entity.userinfo;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月3日14:08:27$
 */

import com.my.dev.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 日历月份
 *
 * @author sunt
 * @version V1.0
 * @ClassName: CalMonthEntity
 * @date 2017年11月8日
 */
@Data
@Entity //声明一个实体，用的是Java规范下的注解
@Table(name = "sys_user") //映射的表名称
public class SysUserEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_status",columnDefinition = " int COMMENT '用户状态 1-未激活 2-已激活 3-已冻结 4-已失效'")
    private Integer userStatus;

    @Column(name = "user_type",columnDefinition = " int COMMENT '0-平台用户 1-组织用户 2-个人用户 4-VIP用户'")
    private Integer userType;

    @Column(name = "user_no",columnDefinition = " varchar(20) COMMENT '用户编号'")
    private String userNo;

    @Column(name = "user_name",columnDefinition = " varchar(50) COMMENT '用户名'")
    private String userName;

    @Column(name = "user_phone",columnDefinition = " varchar(20) COMMENT '手机号'")
    private String userPhone;

    @Column(name = "user_mail",columnDefinition = " varchar(64) COMMENT '邮箱'")
    private String userMail;

    @Column(name = "user_pwd",columnDefinition = " varchar(64) COMMENT '密码'")
    private String userPwd;

    @Column(name = "user_salt",columnDefinition = " varchar(64) COMMENT '盐值'")
    private String userSalt;

    @Column(name = "org_id",columnDefinition = " int COMMENT '所属组织'")
    private Integer orgId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
