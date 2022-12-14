<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
	<!--引入JQuery的包，才可以使用JQuery语法-->
	<script src="../../js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/admin/product/add.jsp";
			}
			//窗口文档流加载完毕之后调用函数
			$(document).ready(function () {
			    //# 代表：获取id名称
				$("#is_hot option[value = ${qv.isHot}]").prop("selected" , true);
            });

            function delConfirm(pid) {
                var b = confirm("您确定要删除吗？");
                if(b){//点击了确定按钮
                    window.location.href = "${pageContext.request.contextPath}/adminProductDel?pid=" + pid;
                }
            }
		</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/adminProductList"
		method="post">
		<!--可以一次筛选后将筛选条件回显到输入框-->
		商品名称:<input type="text" placeholder="请输入商品名称" value="${qv.pname}" name="pname"/>
		&nbsp;&nbsp;&nbsp;
		商品分类:
		<select name="cid">
			<option value="">不限</option>
			<c:forEach items="${categoryList}" var="cg">
				<option value="${cg.cid}"
						<c:if test="${cg.cid == qv.cid}">selected</c:if>
				>${cg.cname}</option>
			</c:forEach>

		</select>
		&nbsp;&nbsp;&nbsp;
		是否热门:
		<select name="isHot" id="is_hot">
			<option value="">不限</option>
			<option value="1">是</option>
			<option value="0">否</option>
		</select>
		&nbsp;&nbsp;&nbsp;
		<input type="submit" value="搜索"/>
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>

					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="18%">序号</td>
								<td align="center" width="17%">商品图片</td>
								<td align="center" width="17%">商品名称</td>
								<td align="center" width="17%">市场价格</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${productList}" var="p" varStatus="vs">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${vs.count}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><img width="40" height="45" src="${p.pimage}"></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${p.pname}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${p.marketPrice}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${p.shopPrice}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										<c:if test="${p.isHot == 1}">是</c:if>
										<c:if test="${p.isHot == 0}">否</c:if>
									</td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/adminProductEdit?pid=${p.pid}">
											<img
											src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a href="#" onclick="delConfirm('${p.pid}')"> <img
											src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>

			</TBODY>
		</table>
	</form>
</body>
</HTML>

