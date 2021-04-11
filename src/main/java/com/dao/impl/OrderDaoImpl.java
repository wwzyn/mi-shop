package com.dao.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.entity.OrderItem;
import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.time.chrono.JapaneseDate;

public class OrderDaoImpl implements OrderDao {
    //定义QueryRunner对象,sql语句
    QueryRunner qr = null;
    String sql = null;

    //添加订单
    @Override
    public void insertOrder(Order order) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "insert into orders values(?,?,?,?,?,?,?,?)";
            qr.update(sql,order.getOid(),order.getOrdertime(),order.getTotal(),order.getUser().getState(),order.getAddress(),
                          order.getUser().getName(),order.getUser().getTelephone(),order.getUser().getUid());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //添加订单项
    @Override
    public void insertOrderItem(OrderItem orderItem) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "insert into orderitem values(?,?,?,?,?)";
            qr.update(sql,orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getProduct().getPid(),orderItem.getOrder().getOid());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
