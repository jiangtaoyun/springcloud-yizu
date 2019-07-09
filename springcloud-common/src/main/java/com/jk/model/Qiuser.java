package com.jk.model;

public class Qiuser {
    private Integer yid;

    private String yname;

    private String ypwd;

    private Integer qid;

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname == null ? null : yname.trim();
    }

    public String getYpwd() {
        return ypwd;
    }

    public void setYpwd(String ypwd) {
        this.ypwd = ypwd == null ? null : ypwd.trim();
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    @Override
    public String toString() {
        return "Qiuser{" +
                "yid=" + yid +
                ", yname='" + yname + '\'' +
                ", ypwd='" + ypwd + '\'' +
                ", qid=" + qid +
                '}';
    }
}