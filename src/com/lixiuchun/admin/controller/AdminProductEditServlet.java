package com.lixiuchun.admin.controller;



import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.AdminProductServiceImpl;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;
import com.lixiuchun.common.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminProductEdit")
public class AdminProductEditServlet extends HttpServlet {

    AdminProductService adminProductService;

    CategoryService categoryService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");
        adminProductService = new AdminProductServiceImpl();

        Product product = adminProductService.getProductByPid(pid);//根据pid主键获取商品详细信息

        if(null != product){
            categoryService = new CategoryServiceImpl();
            List<Category> categoryList = categoryService.getCategoryList();//获取商品类
            req.setAttribute("product" , product);
            req.setAttribute("categoryList" , categoryList);
            req.getRequestDispatcher("/admin/product/edit.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
