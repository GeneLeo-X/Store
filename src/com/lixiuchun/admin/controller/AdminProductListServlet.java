package com.lixiuchun.admin.controller;

import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.impl.AdminProductServiceImpl;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.CategoryServiceImpl;
import com.lixiuchun.admin.vo.QueryVo;

import com.lixiuchun.common.Product;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/adminProductList")
public class AdminProductListServlet extends HttpServlet {

    private CategoryService categoryService;

    private AdminProductService adminProductService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryService = new CategoryServiceImpl();
        adminProductService = new AdminProductServiceImpl();
        req.setCharacterEncoding("utf-8");
        List<Category> categoryList = categoryService.getCategoryList();

        try {
            QueryVo qv = new QueryVo();
            BeanUtils.populate(qv , req.getParameterMap());
            List<Product> productList = adminProductService.getProductListByQueryVo(qv);
            req.setAttribute("productList" , productList);
            req.setAttribute("qv" , qv);//回显（商品的筛选条件）
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //刷新列表页面的数据
        req.setAttribute("categoryList" , categoryList);
        req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
