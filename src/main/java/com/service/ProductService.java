package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {
    List SelectHotProducts(int i);

    List SelectProductsByCid(String cid);

    Product SelectProductByPid(String pid);
}
