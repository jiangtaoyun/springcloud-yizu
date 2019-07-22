package com.jk.model;


import java.io.Serializable;
import java.util.List;


public class TreeBean implements Serializable {
    private  Integer id;
    private  String text;
    private  String href;
    private  Integer pid;
    private List<TreeBean> nodes;
    private Boolean seletetable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<TreeBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeBean> nodes) {
        this.nodes = nodes;
    }

    public Boolean getSeletetable() {
        return seletetable;
    }

    public void setSeletetable(Boolean seletetable) {
        this.seletetable = seletetable;
    }
}
