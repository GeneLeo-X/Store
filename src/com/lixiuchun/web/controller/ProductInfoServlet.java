package com.lixiuchun.web.controller;

import com.lixiuchun.web.bean.Product;
import com.lixiuchun.web.service.ProductService;
import com.lixiuchun.web.service.impl.ProductServicImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {

    ProductService productService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService = new ProductServiceImpl();
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");

        Product product = productService.getProductByPid(pid);
        if(null != product){
            req.setAttribute("product",product);

        }
        req.getRequestDispatcher("/product_info.jsp").forward(req,resp);

//        System.out.println(product);










    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
