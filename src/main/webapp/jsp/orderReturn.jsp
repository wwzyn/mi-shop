<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>订单支付成功页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<%-- 导入头部 --%>
<%@include file="/jsp/header.jsp" %>

<div style="width: 100%">
    <div style="width:30%;float: left">&nbsp;</div>
    <div style="width:40%;float: left"><span style="font-size: 50px; color: green">您已付款成功...</span></div>
    <div style="width:30%;float: left">
        <a href="${pageContext.request.contextPath}/index?method=index"> <button class="btn-info">返回主页面</button></a>
        <a href="${pageContext.request.contextPath}/product?method=cartFindAll"><button class="btn-info">返回购物车</button></a>
        <a href="${pageContext.request.contextPath}/order?method=orderList"> <button class="btn-info">查看订单列表</button></a>
    </div>
</div>







</div>
<!--
    描述：页脚部分
-->
<div class="container-fluid">
    <div style="margin-top:50px;">
        <img src="${pageContext.request.contextPath}/img/footer.png" width="100%" height="78" alt="我们的优势" title="我们的优势" />
    </div>

    <div style="text-align: center;margin-top: 5px;">
        <ul class="list-inline">
            <li><a href="info.html">关于我们</a></li>
            <li><a>联系我们</a></li>
            <li><a>招贤纳士</a></li>
            <li><a>法律声明</a></li>
            <li><a>友情链接</a></li>
            <li><a>支付方式</a></li>
            <li><a>配送方式</a></li>
            <li><a>服务声明</a></li>
            <li><a>广告声明</a></li>
        </ul>
    </div>
    <div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
        Copyright &copy;2020-2030  Rice mall
    </div>
</div>
</body>
</html>
