package com.lixiuchun.admin.vo;

public class QueryVo {

    private String pname;
    private String cid;
    private String isHot;

    public QueryVo() {
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "pname='" + pname + '\'' +
                ", cid='" + cid + '\'' +
                ", isHot='" + isHot + '\'' +
                '}';
    }
}
