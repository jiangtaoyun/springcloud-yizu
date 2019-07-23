package com.jk.model;

import java.io.Serializable;

/**
 * @Auther: 16654
 * @Date: 2019/7/11 14:17
 * @Description:
 */
public class TiaoBanModelZcy implements Serializable {
    private static final long serialVersionUID = -7312558145254987851L;
    private Integer workid;

    private Integer work;

    private Integer typeid;

    private Integer minmoeny;

    private Integer maxmoeny;

    private Integer xueli;

    private Integer agelimit;

    private Integer nature;

    private Integer scale;

    private Integer compid;

    private Integer areaid;

    private Integer top;

    private Integer qtotpe;

    private Integer biaoqianid;
    /*↑职位*/


    /*职位名称*/
    private String tname;

    /*↓企业*/
    private Integer qid;

    private String qname;

    private Integer qtype;

    private Integer qnature;

    private Integer qscale;

    private String qcode;

    private Integer qarea;

    private String qurl;

    private String qaddress;

    private String qinfo;

    private String qlogo;

    private Integer userpingid;

    private String qpeople;

    private String qphone;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getMinmoeny() {
        return minmoeny;
    }

    public void setMinmoeny(Integer minmoeny) {
        this.minmoeny = minmoeny;
    }

    public Integer getMaxmoeny() {
        return maxmoeny;
    }

    public void setMaxmoeny(Integer maxmoeny) {
        this.maxmoeny = maxmoeny;
    }

    public Integer getXueli() {
        return xueli;
    }

    public void setXueli(Integer xueli) {
        this.xueli = xueli;
    }

    public Integer getAgelimit() {
        return agelimit;
    }

    public void setAgelimit(Integer agelimit) {
        this.agelimit = agelimit;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getQtotpe() {
        return qtotpe;
    }

    public void setQtotpe(Integer qtotpe) {
        this.qtotpe = qtotpe;
    }

    public Integer getBiaoqianid() {
        return biaoqianid;
    }

    public void setBiaoqianid(Integer biaoqianid) {
        this.biaoqianid = biaoqianid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public Integer getQtype() {
        return qtype;
    }

    public void setQtype(Integer qtype) {
        this.qtype = qtype;
    }

    public Integer getQnature() {
        return qnature;
    }

    public void setQnature(Integer qnature) {
        this.qnature = qnature;
    }

    public Integer getQscale() {
        return qscale;
    }

    public void setQscale(Integer qscale) {
        this.qscale = qscale;
    }

    public String getQcode() {
        return qcode;
    }

    public void setQcode(String qcode) {
        this.qcode = qcode;
    }

    public Integer getQarea() {
        return qarea;
    }

    public void setQarea(Integer qarea) {
        this.qarea = qarea;
    }

    public String getQurl() {
        return qurl;
    }

    public void setQurl(String qurl) {
        this.qurl = qurl;
    }

    public String getQaddress() {
        return qaddress;
    }

    public void setQaddress(String qaddress) {
        this.qaddress = qaddress;
    }

    public String getQinfo() {
        return qinfo;
    }

    public void setQinfo(String qinfo) {
        this.qinfo = qinfo;
    }

    public String getQlogo() {
        return qlogo;
    }

    public void setQlogo(String qlogo) {
        this.qlogo = qlogo;
    }

    public Integer getUserpingid() {
        return userpingid;
    }

    public void setUserpingid(Integer userpingid) {
        this.userpingid = userpingid;
    }

    public String getQpeople() {
        return qpeople;
    }

    public void setQpeople(String qpeople) {
        this.qpeople = qpeople;
    }

    public String getQphone() {
        return qphone;
    }

    public void setQphone(String qphone) {
        this.qphone = qphone;
    }
}
