package com.lixiuchun.web.dao;


import com.lixiuchun.common.util.C3p0Pool;
import com.lixiuchun.web.bean.Cart;
import com.lixiuchun.web.bean.CartAndProduct;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CartDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public Integer addCart(Cart cart) {

        try {
            Long isExit = (Long)qr.query("select count(*) from t_cart c where c.uid = ? and c.pid = ?" , new ScalarHandler() , cart.getUid() , cart.getPid());
            if(isExit > 0L){//购物车中已经存在该用户与该商品了。
                //更新数据库原有的数量信息
                String sql = "update t_cart set count = count + ? where uid = ? and pid = ?";
                int rows = qr.update(sql, cart.getCount(), cart.getUid(), cart.getPid());
                return rows;
            }else{
                String sql = "insert into t_cart(uid , pid , count) values(? , ? , ?)";
                return qr.update(sql , cart.getUid(), cart.getPid() , cart.getCount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CartAndProduct> getCartList(String uid) {

        String sql = "select c.count , c.id , p.pid , p.pimage , p.pname , p.shop_price shopPrice from t_cart c , product p where c.pid = p.pid and c.uid = ?";
        try {
            return qr.query(sql , new BeanListHandler<>(CartAndProduct.class) , uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public Integer updateCart(String count, String id) {
        String sql = "update t_cart set count = ? where id = ?";

        try {
            return qr.update(sql , count , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteCartById(String id) {
        String sql = "delete from t_cart where id = ?";

        try {
            qr.update(sql , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
