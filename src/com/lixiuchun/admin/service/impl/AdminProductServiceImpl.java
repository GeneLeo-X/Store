package com.lixiuchun.admin.service.impl;

import com.lixiuchun.admin.dao.AdminProductDao;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.vo.QueryVo;
import com.lixiuchun.common.Product;
import org.apache.commons.beanutils.BeanUtils;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class AdminProductServiceImpl implements AdminProductService {
    private AdminProductDao adminProductDao;


    public AdminProductServiceImpl() {
        adminProductDao = new AdminProductDao();
    }

    /**
     * 根据条件查询对应的商品列表
     * @param qv
     * @return
     */
    @Override
    public List<Product> getProductListByQueryVo(QueryVo qv) {
        return adminProductDao.getProductListByQueryVo(qv);
    }

    /**
     * 根据商品主键删除商品
     * @param pid
     * @return
     */

    @Override
    public Integer deleteProductByPid(String pid) {
        return adminProductDao.deleteProductByPid(pid);
    }

    @Override
    public Product getProductByPid(String pid) {
        return adminProductDao.getProductByPid(pid);
    }

    @Override
    public Integer updateProduct(Map<String, String[]> parameterMap) {
        Product product  = new Product();
        try {
            BeanUtils.populate(product,parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return adminProductDao.updateProduct(product);
    }
}
