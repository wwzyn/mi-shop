<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>
		
			<!--
            	
            	描述：菜单栏
            -->
			<%--动态导入--%>
			<jsp:include page="/jsp/header.jsp"></jsp:include>


		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
				</ol>
			</div>

			<c:forEach items="${pb.list}" var="p">
				<div class="col-md-2" style="text-align:center;height:250px;padding:10px 0px;">
					<a href="${pageContext.request.contextPath}/product?method=findProduct&pid=${p.pid}">
						<img src="${pageContext.request.contextPath}/${p.pimage}" width="170" height="170" style="display: inline-block;">
					</a>
					<p><a href="product_info.html" style='color:green'>${p.pname}</a></p>
					<p><font color="#FF0000">商城价：${p.market_price}</font></p>
				</div>
			</c:forEach>

			<%--<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10002.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>圆白菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10003.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>甜玉米</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10004.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>胡萝卜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10005.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>芹菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10006.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>韭菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>

			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10007.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>香菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10008.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>土豆</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10007.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>香菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10008.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>土豆</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10007.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>香菜</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>
			<div class="col-md-2">
				<a href="product_info.htm">
					<img src="${pageContext.request.contextPath}/products/1/cs10008.jpg" width="170" height="170" style="display: inline-block;">
				</a>
				<p><a href="product_info.html" style='color:green'>土豆</a></p>
				<p><font color="#FF0000">商城价：&yen;299.00</font></p>
			</div>--%>

		</div>

		<!--分页 -->
			<div>
				<nav aria-label="Page navigation" style="text-align: center">
					<ul class="pagination">
						<c:if test="${pb.currentPage == 1}">
							<li>
								<a href="javascript:void(0)" aria-label="Previous">
									<span aria-hidden="true" >&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:if test="${pb.currentPage > 1}">
							<li>
								<a href="${pageContext.request.contextPath}/product?method=findAllProductsByCid&currentPage=${pb.currentPage-1}&cid=${cid}" aria-label="Previous">
									<span aria-hidden="true" >&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:forEach begin="1" end="${pb.totalPage}" var="i">
							<%--判断是否为当前页--%>
							<c:if test="${pb.currentPage == i}">
								<%--变亮--%>
								<li class="active">
									<a href="#">${i}</a>
								</li>
							</c:if>
							<%--如果不是当前页进行跳转--%>
							<c:if test="${pb.currentPage != i}">
								<li>
									<a href="${pageContext.request.contextPath}/product?method=findAllProductsByCid&currentPage=${pb.currentPage-1}&cid=${cid}">${i}</a>
								</li>
							</c:if>
						</c:forEach>

						<li>
							<a href="${pageContext.request.contextPath}/product?method=findAllProductsByCid&currentPage=${pb.currentPage+1}&cid=${cid}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
						<span style="font-size: 26px">当前${pb.totalCount}条数据共${pb.totalPage}页</span>
					</ul>
				</nav>
			</div>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">

				<ul style="list-style: none;">
					<li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="${pageContext.request.contextPath}/products/1/cs10001.jpg" width="130px" height="130px" /></li>
				</ul>

			</div>
		</div>
		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy;2020-2030  Rice mall
		</div>

	</body>

</html>