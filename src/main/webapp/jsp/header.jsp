<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <title>头部共用的jsp</title>
</head>
<body>

<div class="container-fluid">

    <!--
        描述：菜单栏
    -->
    <div class="container-fluid">
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/img/logo2.png" />
        </div>
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/img/header.png" />
        </div>
        <div class="col-md-3" style="padding-top:20px">
            <ol class="list-inline">
                <%--user为空--%>
                <c:if test="${empty user}">
                    <li><a href="${pageContext.request.contextPath}/user?method=loginUI">登录</a></li>
                    <li><a href="${pageContext.request.contextPath}/user?method=registerUI">注册</a></li>
                </c:if>
                <c:if test="${not empty user}">
                    欢迎,${user.name} &nbsp;&nbsp;
                    <li><a href="${pageContext.request.contextPath}/user?method=logOut">退出</a></li>
                </c:if>
                <li><a href="">购物车</a></li>
            </ol>
        </div>
    </div>
    <!--
        描述：导航条
    -->
    <div class="container-fluid">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="uid" class="nav navbar-nav">
                        <%--<c:forEach items="${clist}" var="c">
                            <li><a href="#">${c.cname}</a></li>
                        </c:forEach>--%>
                    </ul>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="商品名">
                        </div>
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
    </div>
</body>
<script>
    $(function (){
        $.get("${pageContext.request.contextPath}/category?method=findAll",function (data){
            //获取标签
            $(data).each(function (){

                //遍历data中list集合中的category对象
                $("#uid").append("<li><a href='${pageContext.request.contextPath}/product?method=findAllProductsByCid&cid="+this.cid+"'>"+this.cname+"</a></li>")
            })
        },"json")
    })
</script>
</html>
