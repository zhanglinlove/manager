<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.UserBean" %>
<%
	Cookie[] c = request.getCookies(); 
	String str = null;
	if (c != null){
		for (int i = 0; i < c.length; i++){
			if ("username".equals(c[i].getName()))
				str = c[i].getValue();
		}
	}
	String name = null;
	if (str != null){
		UserBean user = (UserBean)request.getSession().getAttribute(str);
		name = user.getUsername();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/manager.css">
</head>
<body>
	<div class="top">
		欢迎<%=request.getAttribute("username") %>进入商城管理系统。<a>退出</a>
	</div>
	<div class="left">
		<ul>
			<li><a href="#" data="http://localhost:8080/page/admin/addShop.jsp">商品添加</a></li>
			<li><a href="#" data="http://localhost:8080/page/admin/selectShop.jsp">商品查询</a></li>
			<li><a href="#" data="http://localhost:8080/show">商品类别展示</a></li>
			<li><a href="#" data="http://localhost:8080/page/admin/addCategory.jsp">商品类别添加</a></li>
		</ul>
	</div>
	<div class="cotent">
		<iframe scrolling="auto" src="" frameborder="0" id="frame"></iframe>
	</div>
	
	<script src="../../js/jquery-1.10.2.min.js"></script>
	<script >
		$(function(){
			$(".left ul li a").click(function(){
				var url = $(this).attr('data');
				$("#frame").attr('src',url);
			});
		})
		
		$('.top a').click(function(){
			self.location.href=getLocation()+'/user/logout?flag=1'
		});
		
		function getLocation(){
			var href = document.location.href;
			var path = document.location.pathname;
			var pos = href.indexOf(path);
			var local = href.substring(0,pos);
			return local;
		}
	</script>
</body>
</html>