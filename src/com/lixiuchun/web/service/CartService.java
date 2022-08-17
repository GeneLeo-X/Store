package com.lixiuchun.web.service;

import com.lixiuchun.web.bean.CartAndProduct;


import java.util.List;
import java.util.Map;

public interface CartService {
    Integer addCart(Map<String, String[]> parameterMap);

    List<CartAndProduct> getCartList(String uid);

    Integer updateCart(String count, String id);

    void deleteCartById(String id);
}
