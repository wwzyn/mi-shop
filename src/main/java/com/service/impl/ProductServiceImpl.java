package com.service.impl;

import com.dao.ProductDao;
import com.dao.impl.ProductDaoImpl;
import com.entity.PageBean;
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
    //通过cid查询手机和电脑(分页查询)
    @Override
    public PageBean SelectProductsByCid(String cid, String cpage) {
        //创建分页对象
        PageBean pb = new PageBean();
        //设置当前页数
        int currentpage = Integer.parseInt(cpage);
        pb.setCurrentPage(currentpage);
        //设置每页显示条数
        int pageSize = 12;
        pb.setPageSize(pageSize);
        //调用dao层对象来获取总条数
        int count = pd.SelectCount(cid);
        pb.setTotalCount(count);
        //计算总页数
        int totalPage = (count%pageSize==0?(count/pageSize):((count/pageSize)+1));
        pb.setTotalPage(totalPage);
        //获取每页起始行数
        int start = (currentpage-1)*pageSize;
        //获取商品list集合
        List plist = pd.SelectProductsByCid(start,pageSize,cid);
        pb.setList(plist);
        return pb;
    }
    //通过pid查询商品详细信息
    @Override
    public Product SelectProductByPid(String pid) {
        return pd.SelectProductByPid(pid);
    }
}
