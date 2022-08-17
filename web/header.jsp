<%@ page import="com.lixiuchun.web.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>



<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function searchProductsByWord(obj) {
		var word = $(obj).val();

		var contentStr = "";
		if(null != word && word != ""){//存在关键词在模糊查询
			$.ajax({
				url: "${pageContext.request.contextPath}/searchProduct",
				data: {"word":word},
				success:function (data) {
					for(var i = 0 ; i < data.length ; i++){
						//套上超链接，负责处理商品点击事件，跳转商品详情页，但注意：需要匹配正确的商品主键
						contentStr += "<a href='${pageContext.request.contextPath}/productInfo?pid="+data[i].pid+"'><div style='font-size: 10px ; padding: 5px;' onmouseover='selectedFn(this)' " +
								"onmouseout='unSelectedFn(this)'>" + data[i].pname + "</div></a>"
					}
					$("#prod_content").html(contentStr);
					$("#prod_content").css("display" , "block");
				} ,
				type: "post",
				dataType: "json"
			});
		}else{
			$("#prod_content").css("display" , "none");
		}
	}

	function selectedFn(obj) {
		$(obj).css("background" , "#2aabd2");
	}

	function unSelectedFn(obj) {
		$(obj).css("background" , "#ffffff");
	}


</script>

<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<%
				Object user = session.getAttribute("user");
				if(user == null) {
					out.write("<li><a href=\"login.jsp\">登录</a></li>");
					out.write("<li><a href=\"register.jsp\">注册</a></li>");
					out.write("<li><a href=\""+request.getContextPath()+"/login.jsp\">购物车</a></li>");
					out.write("<li><a href=\"order_list.jsp\">我的订单</a></li>");
				} else {
					out.write("欢迎," + ((User)user).getName());
					out.write("<li><a href=\""+request.getContextPath()+"/cartList?uid="+((User) user).getUid()+"\">购物车</a></li>");
					out.write("<li><a href=\"order_list.jsp\">我的订单</a></li>");
				}
			%>
<%--			<li><a href="login.jsp">登录</a></li>--%>
<%--			<li><a href="register.jsp">注册</a></li>--%>
<%--			<li><a href="cart.jsp">购物车</a></li>--%>
<%--			<li><a href="order_list.jsp">我的订单</a></li>--%>
		</ol>
	</div>
</div>

<!-- 导航条 -->
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/categoryListOfProd">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
<%--					<li class="active"><a href=<%=request.getContextPath()%>"/productList">手机数码<span class="sr-only">(current)</span></a></li>--%>
<%--					<li><a href="#">电脑办公</a></li>--%>
<%--					<li><a href="#">化妆品</a></li>--%>
<%--					<li><a href="#">鞋靴箱包</a></li>--%>


				<c:forEach items="${categoryList}" var="cg">
					<li><a href="${pageContext.request.contextPath}/productList?cid=${cg.cid}">${cg.cname}</a></li>
				</c:forEach>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative">
						<input type="text" class="form-control" placeholder="Search" onkeyup="searchProductsByWord(this)"/>
						<!--position : 让出位置，防止挤乱布局  z-index ： 图层设定，正整数越大，优先级越高-->
						<div id="prod_content" style="width: 196px ; height: 220px ; background: white; margin-top: 2px ;
							 display: none;
						     position: absolute; z-index: 1000" ></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>