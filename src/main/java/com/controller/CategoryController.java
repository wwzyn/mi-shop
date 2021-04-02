package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CategoryService;
import com.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends BaseController{
    //获取service对象
    CategoryService cs = new CategoryServiceImpl();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List list = cs.findAllCategoryService();
        //将list转换为json字符串
        //String jsonStr = JsonUtils.list2json(list);
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(list);
        //System.out.println("json字符"+jsonStr);
        response.setContentType("text/css;charset=utf-8");
        response.getWriter().print(jsonStr);
        return null;
    }
}
