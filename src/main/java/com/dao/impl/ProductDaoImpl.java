package com.dao.impl;

import com.dao.ProductDao;
import com.entity.Product;
import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    //定义QueryRunner对象,sql语句
    QueryRunner qr = null;
    String sql = null;

    //查询所有热门商品
    @Override
    public List SelectHotProducts(int i) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            System.out.println(i);
            sql = "select pid,pname,market_price,shop_price,pimage,pdesc,pflag from product where is_hot = ?";
            List list = qr.query(sql,new BeanListHandler<Product>(Product.class),i);
            //System.out.println("热门商品"+list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //通过cid查询数据集合
    @Override
    public List SelectProductsByCid(int start, int pageSize, String cid) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from product where cid = ? limit ?,?";
            List list = qr.query(sql,new BeanListHandler<Product>(Product.class),cid,start,pageSize);
            System.out.println("通过cid查询数据:"+list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //通过pid查询商品详细信息
    @Override
    public Product SelectProductByPid(String pid) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from product where pid = ?";
            Product product= qr.query(sql, new BeanHandler<Product>(Product.class), pid);
            System.out.println("商品"+product);
            return product;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //通过cid查询数据总数
    @Override
    public int SelectCount(String cid) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select count(*) from product where cid = ?";
            Object query = qr.query(sql, new ScalarHandler<>(), cid);
            return Integer.parseInt(String.valueOf(query));
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
