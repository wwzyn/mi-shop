package com.controller;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.service.ProductService;
import com.service.UserService;
import com.utils.MyFactoryBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class CartController extends BaseController{

    //跳转购物车界面
    public String cartUI(HttpServletRequest request, HttpServletResponse response){
        return "/jsp/cart.jsp";
    }

    //获取购物车对象
    public Cart getCart(HttpServletRequest request){
        //从session中获取cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //判断是否为空
        if (cart==null){
            //session中不存在cart
            cart = new Cart();
            //给session中添加一个cart
            request.getSession().setAttribute("cart",cart);
        }
        return cart;
    }

    //添加到购物车
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取商品数量
        String num = request.getParameter("count");
        int count = Integer.parseInt(num);
        //获取商品id
        String pid = request.getParameter("pid");
        //通过pid获取商品信息
        //创建service对象
        ProductService ps = (ProductService) MyFactoryBean.getBean("productService");
        //获取product
        Product product = ps.SelectProductByPid(pid);
        //创建购物车项(商品,数量)
        CartItem cartItem = new CartItem(product,count);
        //获取购物车
        Cart cart = getCart(request);
        //将购物车项加入购物车中
        cart.add2Cart(cartItem);
        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    }

    //删除商品
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取商品id
        String pid = request.getParameter("pid");
        //获取购物车
        Cart cart = getCart(request);
        //删除商品
        cart.removeCartItemFromCart(pid);
        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    }

    //清空购物车
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取购物车
        Cart cart = getCart(request);
        //暴力删除
        cart.clearCart();
        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    }
}
