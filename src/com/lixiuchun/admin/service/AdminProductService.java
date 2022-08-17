package com.lixiuchun.admin.service;

import com.lixiuchun.admin.dto.Product;
import com.lixiuchun.admin.vo.QueryVo;


import java.util.List;

public interface AdminProductService {

    List<Product> getProductListByQueryVo(QueryVo qv);
}
