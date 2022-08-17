package com.lixiuchun.web.dao;


import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }
    public Integer getIsExitUser(String username) {

        try {
            Long l = (Long)qr.query("select count(*) from user where username = ?" , new ScalarHandler() , username);
            return l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
