package com.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zhangyang
 * @Date: 16:06
 * @Version 1.0
 * 购物车实体
 */
public class Cart {

    //包含很多个购物车项
    //key:包含的商品id
    //value:多个购物车项
    private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>() ;

    //Map的方法:Collection<V> values() 获取键对应的值(前端直接cart.items)
    public Collection<CartItem> getItems(){
        return map.values() ;
    }

    //总计金额
    private Double total  = 0.0 ;//总计金额

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    //定义一些功能:添加购物车/删除购物车/清空购物车
    //添加购物车项到购物车中
    public void add2Cart(CartItem cartItem) {
        //判断购物车中的商品是否重复添加
        //购物车项获取商品id
        String pid = cartItem.getProduct().getPid();

        //Map结构:containsKey
        //如果当前购物车项中包含了商品id
        if(map.containsKey(pid)){
            //商品重复
            //获取以前的购物车项
            CartItem oldCartItem = map.get(pid);
            //用以前的oldCartItem获取它的商品数量+cartItem的商品数量
            oldCartItem.setCount(oldCartItem.getCount()+cartItem.getCount()) ;
        }else{
            //如果不重复
            //直接添加

            map.put(pid,cartItem) ; //添加当前新的商品id以及新添加的购物车项

        }

        //设置总计金额
//        total += map.get(pid).getSubTotal();
        total += cartItem.getSubTotal(); //0.0和商品的小计金额
    }


    //定义删除购物车项
    public  void removeCartItemFromCart(String pid){
        CartItem cartItem = map.remove(pid); //通过键删除,返回被删除的键对应的值

        //设置金额
        //总计金额
        total -= cartItem.getSubTotal() ;

    }

    //清空购物
    public void clearCart(){
        map.clear(); ;

        //总计金额
        total = 0.0 ;
    }

}
