package com.service.impl;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.entity.Product;
import com.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    //创建dao对象
    ProductDao pd = new ProductDaoImpl();
    //查询热门和新品
    @Override
    public List SelectHotProducts(int i) {

        return pd.SelectHotProducts(i);
    }
    //通过cid查询手机和电脑
    @Override
    public List SelectProductsByCid(String cid) {

        return pd.SelectProductsByCid(cid);
    }
    //通过pid查询商品详细信息
    @Override
    public Product SelectProductByPid(String pid) {
        return pd.SelectProductByPid(pid);
    }
}
