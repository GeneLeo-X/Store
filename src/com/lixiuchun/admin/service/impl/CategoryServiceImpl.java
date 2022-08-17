package com.lixiuchun.admin.service.impl;

import com.lixiuchun.admin.dao.CategoryDao;
import com.lixiuchun.admin.dto.Category;
import com.lixiuchun.admin.service.CategoryService;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        this.categoryDao = new CategoryDao();
    }

    /**
     * 根据分类主键删除分类信息
     * @param cid
     * @return
     */
    @Override
    public Integer delCategoryByCid(String cid) {
        return categoryDao.deleteCategoryByCid(cid);
    }

    /**
     * 获取分类列表
     * @return
     */
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCatgoryList();
    }

    @Override
    public Integer addCategory(String cname) {
        Category category = new Category();
        category.setCname(cname);
        category.setCid(UUID.randomUUID().toString().replaceAll("-" , ""));
        return categoryDao.addCategory(category);
    }

    @Override
    public Category getCategoryByCid(String cid) {
        return categoryDao.getCategoryByCid(cid);
    }

    @Override
    public Integer updateCategory(String cid, String cname) {
        return categoryDao.updateCategory(cid,cname);
    }


}
