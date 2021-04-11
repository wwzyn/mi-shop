package com.controller;

import com.entity.*;
import com.service.OrderService;
import com.utils.MyFactoryBean;
import com.utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/order")
public class OrderController extends  BaseController{
    public String addOrder(HttpServletRequest request, HttpServletResponse response){
        //获取user,判断是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            //错误信息
            request.getSession().setAttribute("msg","请您先登录!");
            return "/jsp/login.jsp";
        }
        //封装订单
        Order order = new Order();
        //订单id
        order.setOid(UUIDUtils.getId());
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //封装总计金额
        order.setTotal(cart.getTotal());
        //封装user
        order.setUser(user);
        //封装时间
        order.setOrdertime(new Date());
        //获取购物车项
        for (CartItem cartItem:cart.getItems() ){
            //创建订单项
            OrderItem orderItem = new OrderItem();
            //订单项id
            orderItem.setItemid(UUIDUtils.getId());
            //传输数据
            //将数量放入订单项
            orderItem.setCount(cartItem.getCount());
            //将小计金额放入订单项
            orderItem.setSubtotal(cartItem.getSubTotal());
            //order放入订单项
            orderItem.setOrder(order);
            //商品放入订单项
            orderItem.setProduct(cartItem.getProduct());
            //将订单项放入订单中
            order.setItems(orderItem);
        }
        // 调用service
        OrderService os = (OrderService) MyFactoryBean.getBean("orderService");
        os.insertOrder(order);
        //将订单存在session中
        request.getSession().setAttribute("bean",order);
        System.out.println(order);
        return "/jsp/order_info.jsp";
    }
}
