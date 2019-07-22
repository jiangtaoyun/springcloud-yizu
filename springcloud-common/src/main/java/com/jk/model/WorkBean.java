package com.jk.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;



public class WorkBean implements Serializable {
    private static final long serialVersionUID = 13558889;

    private Integer workId;//work主键
    private Integer work;//工作地点
    private Integer typeId;//职位外建
    private Integer minMoeny;//最小薪资
    private Integer  maxMoeny;//最大薪资
    private Integer xueLi;//学历
    private Integer ageLimit;//工作年限
    private Integer nature;//工作性质
    private Integer scale;//企业规模
    private Integer top;//置顶
    private Integer compId;//企业外建
    private Integer qTotpe;//职位状态
    private String qName;//企业名称
    private String tname;//职位名称
    private String AREANAME;//地区
    private Integer biaoQianId;//标签关联字段
    private Integer qArea;//企业表地区
    private Integer qId;
    private Integer moeny;
    private String qdate;
    private String esName;
    private  Integer esId;



    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getMinMoeny() {
        return minMoeny;
    }

    public void setMinMoeny(Integer minMoeny) {
        this.minMoeny = minMoeny;
    }

    public Integer getMaxMoeny() {
        return maxMoeny;
    }

    public void setMaxMoeny(Integer maxMoeny) {
        this.maxMoeny = maxMoeny;
    }

    public Integer getXueLi() {
        return xueLi;
    }

    public void setXueLi(Integer xueLi) {
        this.xueLi = xueLi;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
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

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getqTotpe() {
        return qTotpe;
    }

    public void setqTotpe(Integer qTotpe) {
        this.qTotpe = qTotpe;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getAREANAME() {
        return AREANAME;
    }

    public void setAREANAME(String AREANAME) {
        this.AREANAME = AREANAME;
    }

    public Integer getBiaoQianId() {
        return biaoQianId;
    }

    public void setBiaoQianId(Integer biaoQianId) {
        this.biaoQianId = biaoQianId;
    }

    public Integer getqArea() {
        return qArea;
    }

    public void setqArea(Integer qArea) {
        this.qArea = qArea;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
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
}