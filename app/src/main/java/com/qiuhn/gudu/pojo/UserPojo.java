package com.qiuhn.gudu.pojo;


import java.util.Date;

/**
 * Created by qiuhn on 2015/10/18.
 */
public class UserPojo {
    private long id;// 用户ID

    private String username;// 用户名

    private String pwd;// 密码

    private String nickname;// 昵称

    private String realName;// 真实姓名

    private String mobile;// 手机号

    private int sex; // 1男,2女 ,0 未设置

    private Date registerDate;// 注册时间

    private int status;// 0正常，1禁用，2删除

    private String placeCityId;// 所在地区代码

    private String homeCityId;// 家乡地区代码

    private String schoolId;// 学校代码

    private String departId;// 院系代码

    private int degree;// 学历 :1大学生,2硕士,3博士，4中学生

    private int schoolDate;// 入学年份

    private String avatar;// 小头像

    private String highAvatar;// 高清头像

    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPlaceCityId() {
        return placeCityId;
    }

    public void setPlaceCityId(String placeCityId) {
        this.placeCityId = placeCityId;
    }

    public String getHomeCityId() {
        return homeCityId;
    }

    public void setHomeCityId(String homeCityId) {
        this.homeCityId = homeCityId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getSchoolDate() {
        return schoolDate;
    }

    public void setSchoolDate(int schoolDate) {
        this.schoolDate = schoolDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHighAvatar() {
        return highAvatar;
    }

    public void setHighAvatar(String highAvatar) {
        this.highAvatar = highAvatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
