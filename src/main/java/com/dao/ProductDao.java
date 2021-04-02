package com.dao;

import com.entity.Product;

import java.util.List;

public interface ProductDao {
    List SelectHotProducts(int i);

    List SelectProductsByCid(String cid);

    Product SelectProductByPid(String pid);
}
