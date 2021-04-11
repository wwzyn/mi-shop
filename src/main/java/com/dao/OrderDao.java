package com.dao;

import com.entity.Order;
import com.entity.OrderItem;

public interface OrderDao {
    void insertOrder(Order order);
    void insertOrderItem(OrderItem orderItem);
}
