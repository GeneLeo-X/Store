package com.lixiuchun.admin.controller;


import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categoryUpdate")
public class CategoryUpdateServlet extends HttpServlet {

    CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        categoryService = new CategoryServiceImpl();
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        Integer rows = categoryService.updateCategory(cid, cname);
        if(rows > 0){
            //刷新数据
            req.setAttribute("categoryList" , categoryService.getCatgoryList());
            req.getRequestDispatcher("/admin/category/list.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}