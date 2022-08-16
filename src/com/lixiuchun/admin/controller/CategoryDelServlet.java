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
import java.nio.ShortBuffer;
import java.util.List;


@WebServlet("/categoryDel")
public class CategoryDelServlet extends HttpServlet {
    CategoryService categoryService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("utf-8");
//        categoryService = new CategoryServiceImpl();
//        Integer row = categoryService.delCategoryByCid(req.getParameter("cid"));
//
//        if(row >0){
//            resp.sendRedirect(req.getContextPath() + "/categoryList");//刷新页面过程
//        }
        req.setCharacterEncoding("utf-8");
        String cid = req.getParameter("cid");
        System.out.println("cid = " + cid);
        categoryService = new CategoryServiceImpl();
        Integer rows = categoryService.delCategoryByCid(req.getParameter("cid"));
        if(rows > 0){
           /* req.setAttribute("categoryList" , categoryService.getCategoryList());
            req.getRequestDispatcher("/admin/category/list.jsp").forward(req , resp);*/
            resp.sendRedirect(req.getContextPath() + "/categoryList");//刷新页面过程
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
