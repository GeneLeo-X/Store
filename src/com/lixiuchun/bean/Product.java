package com.lixiuchun.bean;

import javax.xml.crypto.Data;
import java.io.Serializable;
/*
CREATE TABLE `product` (
  `pid` varchar(64) NOT NULL,
  `pname` varchar(50) default NULL,
  `market_price` double default NULL,
  `shop_price` double default NULL,
  `pimage` varchar(200) default NULL,
  `pdate` date default NULL,
  `is_hot` int(11) default NULL,
  `pdesc` varchar(255) default NULL,
  `pflag` int(11) default NULL,
  `cid` varchar(32) default NULL,

 */

public class Product implements Serializable {
    private String pid;
    private String pname;
    private Double mark_price;
    private Double shop_price;
    private String pimage;
    private Data pdate;
    private Integer is_hot;
    private String pdesc;
    private Integer pflag;
    private String cid;

    public Product() {
    }

    public Product(String pid, String pname, Double mark_price, Double shop_price, String pimage, Data pdate, Integer is_hot, String pdesc, Integer pflag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.mark_price = mark_price;
        this.shop_price = shop_price;
        this.pimage = pimage;
        this.pdate = pdate;
        this.is_hot = is_hot;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMark_price() {
        return mark_price;
    }

    public void setMark_price(Double mark_price) {
        this.mark_price = mark_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Data getPdate() {
        return pdate;
    }

    public void setPdate(Data pdate) {
        this.pdate = pdate;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", mark_price=" + mark_price +
                ", shop_price=" + shop_price +
                ", pimage='" + pimage + '\'' +
                ", pdate=" + pdate +
                ", is_hot=" + is_hot +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }
}
