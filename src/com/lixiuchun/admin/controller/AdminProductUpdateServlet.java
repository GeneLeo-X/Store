package com.lixiuchun.admin.controller;


import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.AdminProductServiceImpl;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;
import com.lixiuchun.admin.vo.QueryVo;
import com.lixiuchun.common.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminProductUpdate")
public class AdminProductUpdateServlet extends HttpServlet {

    AdminProductService adminProductService;

    CategoryService categoryService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        adminProductService = new AdminProductServiceImpl();

        Integer rows = adminProductService.updateProduct(req.getParameterMap());

        if(rows > 0){
            categoryService = new CategoryServiceImpl();
            List<Category> categoryList = categoryService.getCategoryList();
            req.setAttribute("categoryList" , categoryList);
            List<Product> productList = adminProductService.getProductListByQueryVo(new QueryVo());
            req.setAttribute("productList" , productList);
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}