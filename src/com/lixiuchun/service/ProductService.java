package com.lixiuchun.service;

import com.lixiuchun.bean.Product;
import com.lixiuchun.vo.PageVo;

import java.util.List;

public interface ProductService {

    public List<Product> getProductList();

    PageVo getPageVoByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount);
}
