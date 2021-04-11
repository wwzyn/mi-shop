package com.service.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.entity.OrderItem;
import com.service.OrderService;
import com.utils.JdbcUtils;
import com.utils.MyFactoryBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    //获取dao层对象
    OrderDao orderDao = (OrderDao) MyFactoryBean.getBean("orderDao");
    //添加订单
    @Override
    public void insertOrder(Order order) {
        try{
            //开启事务
            JdbcUtils.startTransaction();
            //JdbcUtils.getConnection().setAutoCommit(false);
            //添加订单
            orderDao.insertOrder(order);
            //获取订单中的多个订单项
            //遍历
            for(OrderItem item:order.getItems()){
                //添加订单项
                orderDao.insertOrderItem(item);
            }
            //提交事务
            JdbcUtils.commitAndClose();
            List list=new ArrayList();

            //JdbcUtils.getConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
