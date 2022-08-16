package com.lixiuchun.web.controller;

import com.lixiuchun.web.bean.User;
import com.lixiuchun.common.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);





        try {
            String sql = "select u.uid,u.name from user u where u.username=? and u.password=?";
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            User user = qr.query(sql,new BeanHandler<>(User.class),username,password);

            if(null != user){
                System.out.println("--------");
                //可以主动控制cookie时间，否则session的时效与cookie一样关闭浏览器则消失
                HttpSession session =req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }else{
                req.setAttribute("msg","用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
