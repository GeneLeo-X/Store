package com.lixiuchun.admin.controller;

import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.service.CategoryService;
import com.lixiuchun.admin.service.impl.AdminProductServiceImpl;
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

@WebServlet("/adminProductDel")
public class AdminProductDelServlet extends HttpServlet {

    private CategoryService categoryService;

    private AdminProductService adminProductService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");
        adminProductService = new AdminProductServiceImpl();
        Integer rows = adminProductService.deleteProductByPid(pid);
        if(rows > 0){
            try {
                categoryService = new CategoryServiceImpl();
                List<Category> categoryList = categoryService.getCategoryList();
                QueryVo qv = new QueryVo();
                BeanUtils.populate(qv , req.getParameterMap());
                List<Product> productList = adminProductService.getProductListByQueryVo(qv);
                req.setAttribute("productList" , productList);
                req.setAttribute("qv" , qv);
                //刷新列表页面的数据
                req.setAttribute("categoryList" , categoryList);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
