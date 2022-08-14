package com.lixiuchun.dao.ProductDao;

import com.lixiuchun.bean.Product;
import com.lixiuchun.util.C3p0Pool;
import com.lixiuchun.vo.PageVo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductDao {

    /**
     *
     * 商品的数据库操作
     */
    private static QueryRunner qr;

    public ProductDao() {
    }

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public List<Product> getProductList() {
        try {

            String sql = "select p.pid ,p.pname,p.pimage,p.shop_price from product p";
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            return  qr.query(sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return Collections.EMPTY_LIST;
    }

//    public PageVo getPageVoByCurrentPageAndMaxCount(String currentPage, Integer maxCount) {
//
//        PageVo pageVo = new PageVo();
//        pageVo.setCurrentPage(currentPage);
//
//
//
//    }


    public Integer getProductCount() {
        String sql = "select count(*) from product";
        try {
            Long productCount = qr.query(sql, new ScalarHandler<>());

            return productCount.intValue();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getProductListByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount) {
        String sql = "select p.pid ,p.pname,p.pimage,p.shop_price from product p limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<>(Product.class),(currentPage-1)*maxCount,maxCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
