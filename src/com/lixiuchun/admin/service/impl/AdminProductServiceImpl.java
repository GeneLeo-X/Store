package com.lixiuchun.admin.service.impl;

import com.lixiuchun.admin.dao.AdminProductDao;
import com.lixiuchun.admin.dto.Product;
import com.lixiuchun.admin.service.AdminProductService;
import com.lixiuchun.admin.vo.QueryVo;


import java.util.List;

public class AdminProductServiceImpl implements AdminProductService {
    private AdminProductDao adminProductDao;

    /**
     * 根据条件查询对应的商品列表
     * @param qv
     * @return
     */
    @Override
    public List<Product> getProductListByQueryVo(QueryVo qv) {
        adminProductDao = new AdminProductDao();
        return adminProductDao.getProductListByQueryVo(qv);
    }
}
