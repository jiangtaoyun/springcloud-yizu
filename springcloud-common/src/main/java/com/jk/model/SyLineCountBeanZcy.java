package com.jk.model;

import java.io.Serializable;

/**
 * @Auther: 16654
 * @Date: 2019/7/12 14:27
 * @Description:
 */
public class SyLineCountBeanZcy implements Serializable {
    private static final long serialVersionUID = 2041805369790201149L;
    private Integer id;//
    private String name;//企业
    private Integer linecount;//人才
    private String refreshtime;//刷新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLinecount() {
        return linecount;
    }

    public void setLinecount(Integer linecount) {
        this.linecount = linecount;
    }

    public String getRefreshtime() {
        return refreshtime;
    }

    public void setRefreshtime(String refreshtime) {
        this.refreshtime = refreshtime;
    }
}
