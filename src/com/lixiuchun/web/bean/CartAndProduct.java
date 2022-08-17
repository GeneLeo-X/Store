package com.lixiuchun.web.bean;

import java.io.Serializable;

public class CartAndProduct extends Product implements Serializable{

    private Long id;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
