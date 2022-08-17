package com.lixiuchun.web.dao.ProductDao;

import com.lixiuchun.common.Product;
import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
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

            String sql = "select p.pid ,p.pname,p.pimage,p.shop_price as shopPrice from product p";
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
        String sql = "select p.pid ,p.pname,p.pimage,p.shop_price as shopPrice from product p limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<>(Product.class),(currentPage-1)*maxCount,maxCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductByPid(String pid) {
        String sql = "select p.pid, p.pname ,p.pimage,p.shop_price as shopPrice ,p.market_price as marketPrice , p.pdesc from product  p where p.pid =?";
        try {
            return qr.query(sql,new BeanHandler<>(Product.class),pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
