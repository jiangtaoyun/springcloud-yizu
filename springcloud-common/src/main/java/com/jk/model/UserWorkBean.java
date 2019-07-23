package com.jk.model;

import java.io.Serializable;

/**
 * @Auther: 16654
 * @Date: 2019/7/18 11:06
 * @Description:
 */
public class UserWorkBean implements Serializable {
    private static final long serialVersionUID = -6452029372252997890L;
    private Integer uzid;//主键

    private Integer jid;//简历id

    private Integer uid;//用户id

    private Integer zid;//职位id

    private Integer qid;//企业id

    private Integer ustatus;//状态

    private String  shenqtime;//申请时间

    public String getShenqtime() {
        return shenqtime;
    }

    public void setShenqtime(String shenqtime) {
        this.shenqtime = shenqtime;
    }

    public Integer getUzid() {
        return uzid;
    }

    public void setUzid(Integer uzid) {
        this.uzid = uzid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "UserWorkBean{" +
                "uzid=" + uzid +
                ", jid=" + jid +
                ", uid=" + uid +
                ", zid=" + zid +
                ", qid=" + qid +
                ", ustatus=" + ustatus +
                '}';
    }
}
