package com.lixiuchun.web.controller;



import com.lixiuchun.web.service.UserService;
import com.lixiuchun.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUser")
public class CheckUserServlet extends HttpServlet {

    UserService userService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        userService = new UserServiceImpl();
        String username = req.getParameter("username");

        Integer count = userService.getIsExitUser(username);

        resp.setContentType("text/html;charset=utf-8");
        if(count > 0){
            resp.getWriter().write("{\"Existed\":\"1\"}");//该用户名已存在！
        }else{
            resp.getWriter().write("{\"Existed\":\"0\"}");//该用户名可用！
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
