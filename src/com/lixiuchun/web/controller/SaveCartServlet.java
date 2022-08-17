package com.lixiuchun.web.controller;

import com.lixiuchun.web.service.CartService;
import com.lixiuchun.web.service.impl.CartServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveCart")
public class SaveCartServlet extends HttpServlet {

    CartService cartService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Java代码编写
        req.setCharacterEncoding("utf-8");
        cartService = new CartServiceImpl();

        Integer rows = cartService.addCart(req.getParameterMap());

        resp.setContentType("text/html;charset=utf-8");
        if(rows > 0){
            resp.getWriter().write("添加成功！");
        }else{
            resp.getWriter().write("添加失败！");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
