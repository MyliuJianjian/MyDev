package com.my.mqinfo;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月3日14:08:27$
 */
import java.io.Serializable;

/**
 * 日历月份
 *
 * @author sunt
 * @version V1.0
 * @ClassName: CalMonthEntity
 * @date 2017年11月8日
 */
public class SysUserInfo implements Serializable {

    private Integer userId;

    private Integer userStatus;

    private Integer userType;

    private String userNo;

    private String userName;

    private String userPhone;

    private String userMail;

    private String userPwd;

    private String userSalt;

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
