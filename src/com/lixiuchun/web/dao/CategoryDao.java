package com.lixiuchun.web.dao;


import com.lixiuchun.common.util.C3p0Pool;
import com.lixiuchun.web.bean.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryDao {
    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }


    public List<Category> getCategoryList() {

        String sql = "select cp.cid , cp.cname , cp.count from (select count(p.pid) as count ,c.cid ,  c.cname from category c" +
                " LEFT JOIN product p ON c.cid = p.cid GROUP BY c.cname) cp  where cp.count > 0";
        try {
            return qr.query(sql , new BeanListHandler<>(Category.class) );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
