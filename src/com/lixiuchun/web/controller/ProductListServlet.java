package com.lixiuchun.web.controller;



import com.lixiuchun.web.service.CategoryService;
import com.lixiuchun.web.service.ProductService;
import com.lixiuchun.web.service.impl.CategoryServiceImpl;
import com.lixiuchun.web.service.impl.ProductServiceImpl;
import com.lixiuchun.web.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService;
    private CategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        //从前端获取当前页数
        String currentPage = req.getParameter("currentPage") == null? "1" :req.getParameter("currentPage");

        //从前端接收分类主键 cid
        String cid = req.getParameter("cid");

        Integer maxCount = 12;//获取最大页数/也可以由前端获取


        productService = new ProductServiceImpl();
        categoryService = new CategoryServiceImpl();

            //List<Product> productList = productService.getProductList();
        PageVo pageVo = productService.getPageVoByCurrentPageAndMaxCount(Integer.valueOf(currentPage),maxCount,cid);

        req.setAttribute("pageVo",pageVo);
        req.setAttribute("categoryList" , categoryService.getCategoryList());
        req.getRequestDispatcher("/product_list.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
