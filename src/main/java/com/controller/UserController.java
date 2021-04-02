package com.controller;

import com.constant.Constant;
import com.convert.MyConvert;
import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.MD5Utils;
import com.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

@WebServlet("/user")
public class UserController extends BaseController{
    //新建service类
    UserService us = new UserServiceImpl();
    //跳转登录页面
    public String loginUI(HttpServletRequest request,HttpServletResponse response){
        return "/jsp/login.jsp" ;
    }
    //跳转注册界面
    public String registerUI(HttpServletRequest request, HttpServletResponse response){
        return "/jsp/register.jsp" ;
    }
    //校验用户名是否存在
    public void checkUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取参数
        String username = request.getParameter("username");
        //查询用户是否存在
        boolean result = us.findUserByUserName(username);
        //判断并传给ajax数据
        if (result){
            //存在
            response.getWriter().write("1");
        }else{
            //不存在
            response.getWriter().write("0");
        }
    }
    //注册功能
    public String register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ServletException {

        //先校验验证码
        //获取到用户输入的验证码和session中存储的验证码进行对比
        String usercode = request.getParameter("usercode");
        //获取服务器端存储session里面的验证码
        HttpSession session = request.getSession();
        String  CHECKCODE_SERVER = (String) session.getAttribute("CHECKCODE_SERVER");
        //如果不一致,提示错误信息"验证码输入错误"
        if(usercode==null || !CHECKCODE_SERVER.equalsIgnoreCase(usercode)){
            request.setAttribute("msg","验证码输入错误");
            //请求转发到msg.jsp
            request.getRequestDispatcher("/jsp/msg.jsp").forward(request,response);
        }
        //验证码通过
        //接收前台用户输入的所以参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装User对象        //BeanUtils
        User user = new User() ;
        //使用BeanUtils封装用户数据之前,处理一下日期:String---->Date
        ConvertUtils.register(new MyConvert(), Date.class);
        //参数1:转换器:Convert接口
        //参数2:需要将最终转换器的格式---->Class clazz(目标类型的class)
        //Date类型注册了一个转换器，那么user中的所有类型为Date的字符串都转化为Date类型的数据
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //测试
        System.out.println("获取user:"+user);
        //对密码:md5加密-
        user.setPassword(MD5Utils.md5(user.getPassword())) ;
        //uid:用户编号:UUIDUtils 产生随机
        user.setUid(UUIDUtils.getId());
        //code:用户激活码:UUID 产生随机
        user.setCode(UUIDUtils.getCode()) ;
        //调用service
        UserService us = new UserServiceImpl();
        int i = us.addUser(user);
        //提示
        if (i!=0){
            request.setAttribute("msg","恭喜您,注册成功;");
        }else{
            request.setAttribute("msg","注册失败");
        }
        return "/jsp/msg.jsp" ;
    }
    //用户通过邮件激活
    public String active(HttpServletRequest request,HttpServletResponse response){
        //http://localhost:8080/Project_test2/user?method=active&code=FC37A67AA02E4C3886D7E0AF0886CDA3
        //接收激活码code
        String code = request.getParameter("code");
        //调用service:通过code 查询用户
        User user= us.SelectUserByCode(code);
        //如果查询到用户了
        //提示: 恭喜您,激活成功
        if (user!=null){
            //提示信息
            request.setAttribute("msg","用户已经激活成功,请您<a href='http://localhost:8080//qf_mi_war/user?method=loginUI'>点击登录</a>");
        }
        //提示:对不起,激活失败,重新激活!
        return "/jsp/msg.jsp" ;
    }
    //登录
    public String login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取验证码
        String logincode = request.getParameter("code");
        //System.out.println("验证码"+logincode);
        //获取session
        HttpSession session = request.getSession();
        //获取验证码
        String CHECKCODE_SERVER = (String) session.getAttribute("CHECKCODE_SERVER");
       // System.out.println("验证码2"+CHECKCODE_SERVER);
        //一次验证,删除验证码
        session.removeAttribute("CHECKCODE_SERVER");
        if (logincode==null || !CHECKCODE_SERVER.equalsIgnoreCase(logincode)){
            request.setAttribute("msg","验证码输入错误");
            return "/jsp/login.jsp";
        }
        //验证通过
        //获取用户登录参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //密码加密
        password = MD5Utils.md5(password) ;
        //查询用户
        User user = us.findUserByUserNameAndPassword(username,password);
        //不存在,错误提示
        if(user==null){
            request.setAttribute("msg","用户名或者密码错误");
            return "/jsp/login.jsp";
        }
        //存在,判断是否激活
        //没有激活,请重新去激活
        if (user.getState()!= Constant.USER_ACTIVE_STATE){
            request.setAttribute("msg","用户未激活,请激活");
            return "/jsp/login.jsp";
        }
        //将用户存储在session中
        session.setAttribute("user",user);
        /*//获取勾选数据
        String autouser = request.getParameter("auto_user");
        //判断是否勾选
        if(!autouser.equals("autoUser")){
            //没有勾选
            Cookie cookie = new Cookie("autoUser","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }else{
            //勾选了
            String content = username+":"+password;
            //加密
            content  = URLEncoder.encode(content, "utf-8");//jdk提供加密工具
            Cookie cookie = new Cookie("autoUser",content);
            //设置cookie存活时间(一周)
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
        }*/
        //重定向到首页
        response.sendRedirect(request.getContextPath()+"/");
        return null;
    }
}
