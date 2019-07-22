package com.jk.model;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userid;

    private String password;

    private String userphone;

    private String salt;

    private String usercode;

    private String gremail;

    private String grsex;

    private String grheight;

    private Integer grareaid;

    private String graihao;

    private String imgid;

    private String grzhuanye;

    private Integer statu;

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getGremail() {
        return gremail;
    }

    public void setGremail(String gremail) {
        this.gremail = gremail;
    }

    public String getGrsex() {
        return grsex;
    }

    public void setGrsex(String grsex) {
        this.grsex = grsex;
    }

    public String getGrheight() {
        return grheight;
    }

    public void setGrheight(String grheight) {
        this.grheight = grheight;
    }

    public Integer getGrareaid() {
        return grareaid;
    }

    public void setGrareaid(Integer grareaid) {
        this.grareaid = grareaid;
    }

    public String getGraihao() {
        return graihao;
    }

    public void setGraihao(String graihao) {
        this.graihao = graihao;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    public String getGrzhuanye() {
        return grzhuanye;
    }

    public void setGrzhuanye(String grzhuanye) {
        this.grzhuanye = grzhuanye;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }
}