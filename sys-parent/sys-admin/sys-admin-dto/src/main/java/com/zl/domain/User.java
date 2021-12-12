package com.zl.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author zhongliang
 * @version 1.0.1
 */
public class User implements Serializable {

    private String id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private String phoneNo;
    private String certType;
    private String certNo;
    private String birthday;
    private String lastLoginTime;
    private Integer errLoginTimes;
    private String forbiddenLoginTime;
    private Integer forbiddenLoginPeriod;
    private String forbiddenReason;
    private String lastModifyPwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public Integer getErrLoginTimes() {
        return errLoginTimes;
    }

    public void setErrLoginTimes(Integer errLoginTimes) {
        this.errLoginTimes = errLoginTimes;
    }

    public String getForbiddenLoginTime() {
        return forbiddenLoginTime;
    }

    public void setForbiddenLoginTime(String forbiddenLoginTime) {
        this.forbiddenLoginTime = forbiddenLoginTime == null ? null : forbiddenLoginTime.trim();
    }

    public Integer getForbiddenLoginPeriod() {
        return forbiddenLoginPeriod;
    }

    public void setForbiddenLoginPeriod(Integer forbiddenLoginPeriod) {
        this.forbiddenLoginPeriod = forbiddenLoginPeriod;
    }

    public String getForbiddenReason() {
        return forbiddenReason;
    }

    public void setForbiddenReason(String forbiddenReason) {
        this.forbiddenReason = forbiddenReason == null ? null : forbiddenReason.trim();
    }

    public String getLastModifyPwd() {
        return lastModifyPwd;
    }

    public void setLastModifyPwd(String lastModifyPwd) {
        this.lastModifyPwd = lastModifyPwd == null ? null : lastModifyPwd.trim();
    }

    @Override
    public String toString() {
        return "SUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", certType='" + certType + '\'' +
                ", certNo='" + certNo + '\'' +
                ", birthday='" + birthday + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", errLoginTimes='" + errLoginTimes + '\'' +
                ", forbiddenLoginTime='" + forbiddenLoginTime + '\'' +
                ", forbiddenLoginPeriod='" + forbiddenLoginPeriod + '\'' +
                ", forbiddenReason='" + forbiddenReason + '\'' +
                ", lastModifyPwd='" + lastModifyPwd + '\'' +
                '}';
    }
}
