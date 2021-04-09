package com.service;

import com.entity.PageBean;
import com.entity.Product;

import java.util.List;

public interface ProductService {
    List SelectHotProducts(int i);

    PageBean SelectProductsByCid(String cid, String cpage);

    Product SelectProductByPid(String pid);
}
