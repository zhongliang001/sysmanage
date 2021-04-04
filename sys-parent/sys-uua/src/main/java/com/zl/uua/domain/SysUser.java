package com.zl.uua.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户实体类
 * @author zhongliang
 * @version 1.0.1
 */
public class SysUser implements UserDetails {

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
    private String errLoginTimes;
    private String forbiddenLoginTime;
    private String forbiddenLoginPeriod;
    private String forbiddenReason;
    private String lastModifyPwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getErrLoginTimes() {
        return errLoginTimes;
    }

    public void setErrLoginTimes(String errLoginTimes) {
        this.errLoginTimes = errLoginTimes;
    }

    public String getForbiddenLoginTime() {
        return forbiddenLoginTime;
    }

    public void setForbiddenLoginTime(String forbiddenLoginTime) {
        this.forbiddenLoginTime = forbiddenLoginTime;
    }

    public String getForbiddenLoginPeriod() {
        return forbiddenLoginPeriod;
    }

    public void setForbiddenLoginPeriod(String forbiddenLoginPeriod) {
        this.forbiddenLoginPeriod = forbiddenLoginPeriod;
    }

    public String getForbiddenReason() {
        return forbiddenReason;
    }

    public void setForbiddenReason(String forbiddenReason) {
        this.forbiddenReason = forbiddenReason;
    }

    public String getLastModifyPwd() {
        return lastModifyPwd;
    }

    public void setLastModifyPwd(String lastModifyPwd) {
        this.lastModifyPwd = lastModifyPwd;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
