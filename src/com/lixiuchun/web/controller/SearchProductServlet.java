package com.lixiuchun.web.controller;



import com.alibaba.fastjson.JSON;
import com.lixiuchun.common.Product;
import com.lixiuchun.web.service.ProductService;
import com.lixiuchun.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {

    ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String word = req.getParameter("word");
        productService = new ProductServiceImpl();
        System.out.println("word : " + word);

        List<Product> productList = productService.getProductsByWord(word);

        resp.setContentType("text/html;charset=utf-8");
        //借助于fastjson 来讲Java中的集合、数组、对象 转换为JSON格式
        String productsStr = JSON.toJSONString(productList);
        System.out.println("productsStr = " + productsStr);
        resp.getWriter().write(productsStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
