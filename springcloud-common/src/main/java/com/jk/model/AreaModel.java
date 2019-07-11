package com.jk.model;

import java.io.Serializable;

public class AreaModel implements Serializable {
    private Integer AREAID;
    private String  AREANAME;

    public Integer getAREAID() {
        return AREAID;
    }

    public void setAREAID(Integer AREAID) {
        this.AREAID = AREAID;
    }

    public String getAREANAME() {
        return AREANAME;
    }

    public void setAREANAME(String AREANAME) {
        this.AREANAME = AREANAME;
    }

    @Override
    public String toString() {
        return "AreaModel{" +
                "AREAID=" + AREAID +
                ", AREANAME='" + AREANAME + '\'' +
                '}';
    }
}
