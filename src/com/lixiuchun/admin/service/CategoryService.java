package com.lixiuchun.admin.service;


import com.lixiuchun.admin.dto.Category;

import java.util.List;

public interface CategoryService {


    Integer delCategoryByCid(String cid);



    List<Category> getCategoryList();


    Integer addCategory(String cname);

    Category getCategoryByCid(String cid);

    Integer updateCategory(String cid, String cname);


}
