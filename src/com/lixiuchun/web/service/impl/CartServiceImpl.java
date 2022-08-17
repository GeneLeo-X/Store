package com.lixiuchun.web.service.impl;

import com.lixiuchun.web.bean.Cart;
import com.lixiuchun.web.bean.CartAndProduct;
import com.lixiuchun.web.dao.CartDao;
import com.lixiuchun.web.service.CartService;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {

    static CartDao cartDao;

    static {
        cartDao = new CartDao();
    }

    /**
     * 添加商品进入购物车，若已存在则更新，否则增加条目
     * @param parameterMap
     * @return
     */
    @Override
    public Integer addCart(Map<String, String[]> parameterMap) {
        Cart cart = new Cart();
        try {
            BeanUtils.populate(cart , parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return cartDao.addCart(cart);
    }

    /**
     * 获取购物车列表,根据用户主键
     * @return
     */
    @Override
    public List<CartAndProduct> getCartList(String uid) {

        return cartDao.getCartList(uid);
    }

    /**
     * 根据购物车表主键修改其数量
     * @param count
     * @param id
     * @return
     */
    @Override
    public Integer updateCart(String count, String id) {
        return cartDao.updateCart(count , id);
    }

    /**
     * 根据购物车主键删除购物车内部条目
     * @param id
     */
    @Override
    public void deleteCartById(String id) {
        cartDao.deleteCartById(id);
    }
}
