package com.jk.model;

import java.io.Serializable;

public class CompanyBean implements Serializable {
    private static final long serialVersionUID = 1035183286351728801L;
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
    private String  qtypes;
    private  String sheng;
    private  String shi;
    private  String xian;

    public String getQtypes() {
        return qtypes;
    }

    public void setQtypes(String qtypes) {
        this.qtypes = qtypes;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
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
}