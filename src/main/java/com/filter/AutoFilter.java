package com.filter;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

//@WebFilter(urlPatterns = "/jsp/index.jsp",dispatcherTypes = DispatcherType.FORWARD)
public class AutoFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            String content = null;
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("autoUser")){
                    content = cookie.getValue() ;

                }
            }

            if(content!=null){
                //解码
                content =  URLDecoder.decode(content,"utf-8") ; //解密工具
                String[] strs = content.split(":");
                String username = strs[0] ;
                String password = strs[1] ;

                UserService userService = new UserServiceImpl() ;
                User user = userService.findUserByUserNameAndPassword(username,password);

                if(user!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    HttpServletResponse response = (HttpServletResponse) resp;
                    response.sendRedirect(request.getContextPath()+"/");
                }else{
                    chain.doFilter(req,resp);
                }
            }else{
                chain.doFilter(req,resp);
            }
        }else{
            chain.doFilter(req,resp);
        }
    }
}
