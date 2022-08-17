package com.lixiuchun.admin.dao;

import com.lixiuchun.admin.vo.QueryVo;

import com.lixiuchun.common.Product;
import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminProductDao {

    private static QueryRunner qr;
    static{
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }



    /**
     * 根据条件去数据库查询商品信息
     * @param qv
     * @return
     */

    /*
    #模糊查询，将名称中包含字"三"的商品输出
    #1、%内容 ：以该内容结束的都会匹配成功
    #2、内容%	：以该内容开头的都会匹配成功
    #3、%内容%：以存在该内容的都会匹配成功
     */

    public List<Product> getProductListByQueryVo(QueryVo qv) {
        System.out.println(qv);

        String sql = "select p.pid , p.pname , p.pimage , p.shop_price as shopPrice " +
                ", p.market_price marketPrice " +
                ", p.is_hot isHot from product p  where 1=1 ";//1=1 条件占位，保证SQL语句不会出错



        //有条件就传值
        List<Object> param = new ArrayList<>();

        if(null != qv.getPname() && !qv.getPname().equals("")){//判空操作
            sql += " and p.pname like ? ";
            param.add("%" + qv.getPname() + "%");
        }

        if(null != qv.getCid() && !qv.getCid().equals("")){
            sql += " and p.cid = ? ";
            param.add(qv.getCid());
        }

        if(null != qv.getIsHot() && !qv.getIsHot().equals("")){
            sql += " and p.is_hot = ? ";
            param.add(qv.getIsHot());
        }

        try {
            return qr.query(sql , new BeanListHandler<>(Product.class) ,param.toArray());//数组代替了可变参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;

    }

    public Integer deleteProductByPid(String pid) {
            String sql = "delete from product where pid = ?";

            try {
                return qr.update(sql , pid);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }

    public Product getProductByPid(String pid) {
        String sql ="select p.pid , p.pname , p.pimage , p.shop_price as shopPrice " +
                ", p.market_price marketPrice " +
                ", p.is_hot isHot ,p.pdesc ,p.cid from product p  where p.pid=?";;
        try {
            return qr.query(sql,new BeanHandler<>(Product.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 更新商品信息
     * @param product
     * @return
     */

    public Integer updateProduct(Product product) {
        String sql = "update product set pname = ? , pdesc = ? , cid = ? , is_hot = ? " +
                ", shop_price = ? , market_price = ? where pid = ?";

        try {
            return qr.update(sql , product.getPname() , product.getPdesc() , product.getCid() , product.getIsHot()
                    , product.getShopPrice() , product.getMarketPrice() , product.getPid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
