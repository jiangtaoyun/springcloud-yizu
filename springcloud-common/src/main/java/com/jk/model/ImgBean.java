package com.jk.model;

import java.io.Serializable;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:11
 * @Description:
 */
public class ImgBean implements Serializable {

    private static final long serialVersionUID = -8642836439645881094L;
    private Integer gid;
    private String gname;
    private String gimg;
    private String gurl;
    private Integer gstatus;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    public String getGurl() {
        return gurl;
    }

    public void setGurl(String gurl) {
        this.gurl = gurl;
    }

    public Integer getGstatus() {
        return gstatus;
    }

    public void setGstatus(Integer gstatus) {
        this.gstatus = gstatus;
    }
}
