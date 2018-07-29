<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.UserBean" %>
<%
	String str = (String)request.getAttribute("username");
	
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
<link rel="stylesheet" type="text/css" href="../css/default.css">
</head>
<body>
	<div class="default">
	<c:if test="${empty username }">
		你好，<a href="http://localhost:8080/page/userLogin.jsp">未登陆</a>，<a href="http://localhost:8080/page/register.jsp">免费注册</a>
	</c:if>
	<c:if test="${!empty username }">
		欢迎,<c:out value="${username }"></c:out>,<a>退出</a>
	</c:if>

	</div>
	<div class="default-top">
		<div> </div>
		<div class="middle">
			<input type="text" class="content" placeholder="输入查询数据">
			<input type="button" value="查询" class="search">
		</div>
	</div>
	<div class="default-left">
		<span>人气榜</span>
		<div class="first">
		
		</div>
		<span>推荐商品</span>
		<div class="second">
		
		</div>
		<span>热销商品</span>
		<div class="third">
		
		</div>
	</div>
	<div class="default-right">
		<div class="banner">
		<ul>
			<li>购物车</li>
			<li>会员</li>
			<li>关注</li>
		</ul>
		<div class="cart">
			
		</div>
	</div>
	</div>
	
	<div class="default-main">
		
	</div>
	<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="../js/default.js?j=20160717"></script>
</body>
</html>