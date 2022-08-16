package com.lixiuchun.admin.dao;

import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class CategoryDao {

    static QueryRunner qr;
    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }


    public List<Category> getCatgoryList() {
        String sql = "select c.cid , c.cname from category c";
        try {
            return qr.query(sql,new BeanListHandler<>(Category.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;

    }

    public Integer deleteCategoryByCid(String cid) {
        String sql ="delete from category where cid = ?";
        try {
            return qr.update(sql,cid) ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer addCategory(Category category) {
        try {
            return qr.update("insert into category values(? , ?)" , category.getCid() , category.getCname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Category getCategoryByCid(String cid) {
        String sql ="select c.cid ,c.cname from category c where c.cid=?";
        try {
            return qr.query(sql,new BeanHandler<>(Category.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer updateCategory(String cid, String cname) {
        String sql="update category set cname = ? where cid =?";
        try {
            return qr.update(sql,cname,cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
