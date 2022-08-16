package com.lixiuchun.web.controller;

import com.lixiuchun.web.bean.User;
import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("username: " + req.getParameter("username"));

        User user = new User();

        try {




            BeanUtils.populate(user,req.getParameterMap());

            user.setUid(UUID.randomUUID().toString().replace("-",""));


            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());

            String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
            int row = qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(),
                    user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode());

            if(row > 0){
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }else{
                req.setAttribute("msg","注册信息有误！！！");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }






        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
