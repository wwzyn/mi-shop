package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //统一处理中文乱码
        // req  resp 参数对应的参数类型---->HttpServletRequest/HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取提交方式
        String method = request.getMethod();
        //处理post乱码
        if(method.equalsIgnoreCase("post")){
            //post提交:会有中文乱码
            //tomcat8.0以下:get方式也会乱码 String--->new String(getBytes("utf-8","iso8859-1"))
            request.setCharacterEncoding("utf-8");
        }
        //处理响应乱码
        //response.setContentType("text/css;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //放行
        chain.doFilter(request,response);
    }
}
