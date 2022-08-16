package com.lixiuchun.admin.controller;



import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categoryEdit")
public class CategoryEditServlet extends HttpServlet {

    CategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        categoryService = new CategoryServiceImpl();
        String cid = req.getParameter("cid");
        Category category = categoryService.getCategoryByCid(cid);
        if(null != category){
            req.setAttribute("category" , category);
            req.getRequestDispatcher("/admin/category/edit.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
