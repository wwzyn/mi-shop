package com.dao.impl;

import com.dao.CategoryDao;
import com.entity.Category;
import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    //定义QueryRunner对象,sql语句
    QueryRunner qr = null;
    String sql = null;
    //查询所有商品信息
    @Override
    public List findAllCategory() {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from category";

            List list = qr.query(sql, new BeanListHandler<Category>(Category.class));
            System.out.println(list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
