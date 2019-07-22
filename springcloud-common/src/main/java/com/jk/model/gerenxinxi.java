package com.jk.model;

import java.io.Serializable;

public class gerenxinxi implements Serializable {
    private Integer grid;

    private String gremail;

    private String grsex;

    private String grheight;

    private Integer grareaid;

    private String graihao;

    private String imgid;

    private String grzhuanye;

    private Integer userid;

    public Integer getGrid() {
        return grid;
    }

    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    public String getGremail() {
        return gremail;
    }

    public void setGremail(String gremail) {
        this.gremail = gremail == null ? null : gremail.trim();
    }

    public String getGrsex() {
        return grsex;
    }

    public void setGrsex(String grsex) {
        this.grsex = grsex == null ? null : grsex.trim();
    }

    public String getGrheight() {
        return grheight;
    }

    public void setGrheight(String grheight) {
        this.grheight = grheight == null ? null : grheight.trim();
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
        this.graihao = graihao == null ? null : graihao.trim();
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid == null ? null : imgid.trim();
    }

    public String getGrzhuanye() {
        return grzhuanye;
    }

    public void setGrzhuanye(String grzhuanye) {
        this.grzhuanye = grzhuanye == null ? null : grzhuanye.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}