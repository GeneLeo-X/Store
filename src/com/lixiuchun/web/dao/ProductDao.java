package com.lixiuchun.web.dao;

import com.lixiuchun.common.Product;
import com.lixiuchun.common.util.C3p0Pool;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 商品的数据库操作
 */
public class ProductDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    /**
     * 从数据库中查询商品列表
     * @return
     */
    public List<Product> getProductList() {
        String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice from product p";
        try {
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class));
            return productList;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * 获取数据库中商品的数量
     * @return
     */
    public Integer getProductCount() {
        String sql = "select count(*) from product";

        try {
            Long count = (Long)qr.query(sql, new ScalarHandler());
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * #  页数            索引   数量
     *#  1               0      10
     *#  2               10     10
     *#  3               20     10
     *#索引 = (页数 - 1) * 数量
     */
    public List<Product> getProductListByCurrentPageAndMaxCount(Integer currentPage, Integer maxCount) {
        String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice from product p LIMIT ? ,?";

        try {
            return qr.query(sql, new BeanListHandler<>(Product.class) , (currentPage - 1) * maxCount , maxCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    public Product getProductByPid(String pid) {
        String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice , p.market_price marketPrice , p.pdesc from product p where p.pid = ?";
        try {
            return qr.query(sql , new BeanHandler<>(Product.class) , pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByWord(String word) {
        String sql = "select p.pname , p.pid from product p where p.pname like ? LIMIT 5";

        try {
            return qr.query(sql , new BeanListHandler<>(Product.class) , "%" + word + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<Product> getProductListByCurrentPageAndMaxCountAndCid(Integer currentPage, Integer maxCount, String cid) {

        String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice from product p where 1=1 ";

        List<Object> param = new ArrayList<>();
        //判断cid是否存在，存在则进行拼接操作
        if(null != cid && !cid.equals("")){
            sql += " and cid = ? ";
            param.add(cid);
        }
        sql += "LIMIT ? ,?";
        param.add((currentPage - 1) * maxCount);
        param.add(maxCount);
        try {
            return qr.query(sql, new BeanListHandler<>(Product.class) , param.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * 根据分类主键查询下面的商品列表
     * @param cid
     * @return
     */
    public Integer getProductCountByCid(String cid) {
        String sql = "select count(*) from product where 1=1";
        List<Object> param = new ArrayList<>();
        //判断cid是否存在，存在则进行拼接操作
        if(null != cid && !cid.equals("")){
            sql += " and cid = ? ";
            param.add(cid);
        }
        try {
            Long count = (Long)qr.query(sql, new ScalarHandler() , param.toArray());
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
