package com.lixiuchun.admin.service;

import com.lixiuchun.admin.vo.QueryVo;
import com.lixiuchun.common.Product;


import java.util.List;
import java.util.Map;

public interface AdminProductService {

    List<Product> getProductListByQueryVo(QueryVo qv);

    Integer deleteProductByPid(String pid);

    Product getProductByPid(String pid);

    Integer updateProduct(Map<String, String[]> parameterMap);
}
