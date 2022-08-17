package com.lixiuchun.web.vo;



import com.lixiuchun.common.Product;

import java.io.Serializable;
import java.util.List;

public class PageVo implements Serializable{

    private List<Product> productList;

    private Integer currentPage;

    private Integer totalPages;

    private String cid;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
