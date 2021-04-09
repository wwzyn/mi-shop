package com.dao;

import com.entity.Product;

import java.util.List;

public interface ProductDao {
    List SelectHotProducts(int i);

    List SelectProductsByCid(int start, int pageSize, String cid);

    Product SelectProductByPid(String pid);

    int SelectCount(String cid);
}
