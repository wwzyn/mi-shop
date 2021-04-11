package com.controller;

import com.entity.PageBean;
import com.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/product")
public class ProductController extends BaseController{
    //创建service对象
    ProductService ps = new ProductServiceImpl();
    //查询热门以及最新
    public String findList(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //查询热门商品
        int is_hot = 1;
        List<Product> listhot = ps.SelectHotProducts(1);
        if (listhot!=null){
            request.setAttribute("listhot",listhot);
        }
        //转化为json
        //String jsonStr = JsonUtils.list2json(listhot);
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(listhot);
        //System.out.println("json热门"+jsonStr);
        response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonStr);
        //查询最新商品:
        /*return "/jsp/index.jsp" ;*/
        return null;
    }
    //分类型查询
    public String findAllProductsByCid(HttpServletRequest request, HttpServletResponse response){
        //获取cid
        String cid = request.getParameter("cid");
        //System.out.println("cid"+cid);
        //获取分页数据
        String currentPage = request.getParameter("currentPage");
        //String pageSize = request.getParameter("pageSize");
        //判断并赋值
        if (currentPage==null || "".equals(currentPage)){
            currentPage = "1";
        }
        //通过cid查询数据集合,传入当前页码
        PageBean pb = ps.SelectProductsByCid(cid,currentPage);
        //System.out.println("controller 集合"+plist);
        //将pb放入request
        request.setAttribute("cid",cid);
        request.setAttribute("pb",pb);

        return "/jsp/product_list.jsp" ;
    }
    //通过pid查询商品信息(详情页展示)
    public String findProduct(HttpServletRequest request, HttpServletResponse response){
        //获取pid
        String pid = request.getParameter("pid");
        Product p = ps.SelectProductByPid(pid);
        request.setAttribute("p",p);
        return "/jsp/product_info.jsp" ;
    }
}

