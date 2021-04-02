package com.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    //重写service方法
    //在url请求的地址:http://localhost:8080/Project_test2/user?method=add
    //http协议
    //本地域名:8080
    //项目名称
    //user:用户模块/ product/order/category  :模块名称
    //?get请求:后面携带的参数:表示请求的成员方法名称
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //获取方法名称
            String methodName = request.getParameter("method");
            //System.out.println("方法名称"+methodName);
            //为空处理
            if(methodName==null){
                //methodName="findList" ;
                index(request,response);
            }
            //获取子类字节码文件
            Class clazz = this.getClass();
            //System.out.println("clazz:"+clazz);
            //获取子类方法
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //System.out.println("method:"+method);
            //执行方法（invoke）
            String str = (String) method.invoke(this, request, response);
            //有返回值统一转发处理
            if (str!=null){
                //请求转发处理
                request.getRequestDispatcher(str).forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
            //所有的异常:都让他执行RuntimeException
            throw new RuntimeException(e);
        }
    }

    private String index(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
