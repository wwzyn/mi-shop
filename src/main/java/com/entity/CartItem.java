package com.entity;

/**
 * @Author:zhangyang
 * @Date: 16:03
 * @Version 1.0
 * 购物车项实体
 */
public class CartItem {
    private Product product ; //商品实体

    private Integer count ;//商品数量

    private Double subTotal = 0.0 ; //小计金额

    public CartItem() {
    }

    //有参构造方法
    public CartItem(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    //小计金额:=商品的数量*商品单价
    public Double getSubTotal(){
        return product.getShop_price()*count ;
    }
}
