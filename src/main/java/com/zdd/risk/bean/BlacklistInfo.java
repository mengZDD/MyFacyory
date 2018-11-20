package com.zdd.risk.bean;

public class BlacklistInfo {
    private Long seqid;

    private String userid;

    private String oauthuid;

    private String tel;

    private String name;

    private String idcardNo;

    private String address;

    private String ymdhms;

    private String grade;

    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOauthuid() {
        return oauthuid;
    }

    public void setOauthuid(String oauthuid) {
        this.oauthuid = oauthuid == null ? null : oauthuid.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getYmdhms() {
        return ymdhms;
    }

    public void setYmdhms(String ymdhms) {
        this.ymdhms = ymdhms == null ? null : ymdhms.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }
}