package com.service.impl;

import com.dao.CategoryDao;
import com.dao.impl.CategoryDaoImpl;
import com.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    //调用dao层
    CategoryDao cd = new CategoryDaoImpl() ;
    //查询所有商品分类
    @Override
    public List findAllCategoryService() {
        List list = cd.findAllCategory();
        return list;
    }
}
