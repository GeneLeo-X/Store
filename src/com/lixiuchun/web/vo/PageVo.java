package com.lixiuchun.web.vo;

import com.lixiuchun.web.bean.Product;

import java.util.List;

public class PageVo {

    private List<Product> productList;
    private Integer currentPage;
    private Integer totalPages;




    public PageVo() {
    }

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

    @Override
    public String toString() {
        return "PageVo{" +
                "productList=" + productList +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                '}';
    }
}
