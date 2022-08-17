package com.lixiuchun.web.bean;

import java.io.Serializable;

/**
 *  `pid` varchar(64) NOT NULL,
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
public class Product implements Serializable{

    private Long pid;

    private String pname;

    private Double marketPrice;

    private Double shopPrice;

    private String pimage;

    private String pdesc;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
}
