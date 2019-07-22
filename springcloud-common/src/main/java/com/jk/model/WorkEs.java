package com.jk.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName ="zhaopin",type ="t_work")
public class WorkEs implements Serializable {

    @Id
    private Integer workId;

    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",store = true)
    private String qName;//企业名称
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",store = true)
    private String tname;//职位名称
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",store = true)
    private String AREANAME;//地区
    @Field(type = FieldType.Text,searchAnalyzer = "ik_max_word",store = true)
    private Integer qArea;//企业表地区

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
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

    public Integer getqArea() {
        return qArea;
    }

    public void setqArea(Integer qArea) {
        this.qArea = qArea;
    }
}
