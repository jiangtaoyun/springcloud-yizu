package com.jk.model;

import java.io.Serializable;

public class Company implements Serializable {
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

    private String tname;

    private Integer moeny;
    private String qdate;
    private String esName;
    private  Integer esId;

    private Integer stuta;

    public Integer getStuta() {
        return stuta;
    }

    public void setStuta(Integer stuta) {
        this.stuta = stuta;
    }

    private Integer workId;//work主键

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getMoeny() {
        return moeny;
    }

    public void setMoeny(Integer moeny) {
        this.moeny = moeny;
    }

    public String getQdate() {
        return qdate;
    }

    public void setQdate(String qdate) {
        this.qdate = qdate;
    }

    public String getEsName() {
        return esName;
    }

    public void setEsName(String esName) {
        this.esName = esName;
    }

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
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
        this.qname = qname == null ? null : qname.trim();
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
        this.qcode = qcode == null ? null : qcode.trim();
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
        this.qurl = qurl == null ? null : qurl.trim();
    }

    public String getQaddress() {
        return qaddress;
    }

    public void setQaddress(String qaddress) {
        this.qaddress = qaddress == null ? null : qaddress.trim();
    }

    public String getQinfo() {
        return qinfo;
    }

    public void setQinfo(String qinfo) {
        this.qinfo = qinfo == null ? null : qinfo.trim();
    }

    public String getQlogo() {
        return qlogo;
    }

    public void setQlogo(String qlogo) {
        this.qlogo = qlogo == null ? null : qlogo.trim();
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
        this.qpeople = qpeople == null ? null : qpeople.trim();
    }

    public String getQphone() {
        return qphone;
    }

    public void setQphone(String qphone) {
        this.qphone = qphone == null ? null : qphone.trim();
    }
}