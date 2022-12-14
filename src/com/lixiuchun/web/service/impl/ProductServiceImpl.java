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

    /**
     * 根据word关键词模糊查询商品列表
     * @param word
     * @return
     */
    @Override
    public List<Product> getProductsByWord(String word) {
        return productDao.getProductsByWord(word);
    }

    @Override
    public PageVo getPageVoByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount, String cid) {
        PageVo pageVo = new PageVo();
        pageVo.setCurrentPage(currentPage);
        pageVo.setCid(cid);
        //获取数据库商品数量 / maxCount  需要向上取整 Math.ceil() 天花板
        Integer productCount = productDao.getProductCountByCid(cid);
        //计算总页数
        pageVo.setTotalPages((int)Math.ceil(productCount * 1.0/ maxCount));

        List<Product> productList = productDao.getProductListByCurrentPageAndMaxCountAndCid(currentPage , maxCount , cid);
        pageVo.setProductList(productList);
        return pageVo;
    }
}
