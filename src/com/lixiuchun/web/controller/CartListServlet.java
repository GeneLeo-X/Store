package com.lixiuchun.web.controller;

import com.lixiuchun.web.bean.CartAndProduct;
import com.lixiuchun.web.service.CartService;
import com.lixiuchun.web.service.impl.CartServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet {

    CartService cartService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("--------------");
        cartService = new CartServiceImpl();
        String uid = req.getParameter("uid");
        List<CartAndProduct> cartList = cartService.getCartList(uid);
        req.setAttribute("cartList" , cartList);

        req.getRequestDispatcher("/cart.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
