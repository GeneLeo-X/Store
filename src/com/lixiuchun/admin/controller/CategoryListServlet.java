package com.lixiuchun.admin.controller;

import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;
import com.lixiuchun.admin.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categoryList")
public class CategoryListServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryService = new CategoryServiceImpl();
        List<Category> categoryList = categoryService.getCategoryList();

        //刷新列表页面的数据
        req.setAttribute("categoryList",categoryList);
        req.getRequestDispatcher("/admin/category/list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
