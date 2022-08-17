package com.lixiuchun.web.service.impl;

import com.lixiuchun.common.Product;
import com.lixiuchun.web.dao.ProductDao;
import com.lixiuchun.web.service.ProductService;
import com.lixiuchun.web.vo.PageVo;

import java.util.List;

public class ProductServiceImpl implements ProductService  {

    private ProductDao productDao;


    public ProductServiceImpl() {
        this.productDao = new ProductDao();
    }


    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public PageVo getPageVoByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount) {
        PageVo pageVo = new PageVo();

        pageVo.setCurrentPage(currentPage);


        //获取数据库商品数量/maxCount    向上取整（否则会有数据丢失）Math.ceil()
        Integer productCount = productDao.getProductCount();

        //计算总页数
        pageVo.setTotalPages((int) Math.ceil(productCount * 1.0 / maxCount));

        //根据当前页数获取商品列表
        List<Product> productList = productDao.getProductListByCurrentPageAndMaxCount(currentPage,maxCount);
        pageVo.setProductList(productList);

        return pageVo;

    }

    @Override
    public Product getProductByPid(String pid) {
        return productDao.getProductByPid(pid);
    }
}
