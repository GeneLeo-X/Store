package com.lixiuchun.web.service.impl;



import com.lixiuchun.web.bean.Category;
import com.lixiuchun.web.dao.CategoryDao;
import com.lixiuchun.web.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(){
        categoryDao = new CategoryDao();
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
