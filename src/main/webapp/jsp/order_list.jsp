<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html5>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>我的订单列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>


<%@include file="/jsp/header.jsp" %>
		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:9005 </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									5
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:9004 </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									5
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:9003 </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									5
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
							</tr>
						</tbody>
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:9002 </th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									5
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">8</a></li>
					<li><a href="#">9</a></li>
					<li>
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
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