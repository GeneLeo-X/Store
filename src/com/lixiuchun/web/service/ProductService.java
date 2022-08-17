package com.lixiuchun.web.service;

import com.lixiuchun.common.Product;
import com.lixiuchun.web.vo.PageVo;

import java.util.List;

public interface ProductService {

    public List<Product> getProductList();

    PageVo getPageVoByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount);

    Product getProductByPid(String pid);

    List<Product> getProductsByWord(String word);
}
