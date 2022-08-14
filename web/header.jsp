<%@ page import="com.lixiuchun.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
				if(user == null){
					out.write("\t\t\t<li><a href=\"login.jsp\">登录</a></li>\n");
					out.write("\t\t\t<li><a href=\"register.jsp\">注册</a></li>\n");
					out.write("\t\t\t<li><a href=\"cart.jsp\">购物车</a></li>\n");
					out.write("\t\t\t<li><a href=\"order_list.jsp\">我的订单</a></li>\n");


				}else{
					out.write("欢迎，" + ((User)user).getName());
					out.write("\t\t\t<li><a href=\"cart.jsp\">购物车</a></li>\n");
					out.write("\t\t\t<li><a href=\"order_list.jsp\">我的订单</a></li>\n");
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
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href=<%=request.getContextPath()%>"/productList">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">化妆品</a></li>
					<li><a href="#">鞋靴箱包</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>