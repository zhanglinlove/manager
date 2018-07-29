<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user/register" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" class="username" name="username"></td>
		<tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" class="password" name="password"></td>
		<tr>
		<tr>
			<td>确定密码：</td>
			<td><input type="password" class="pwd2"></td>
		<tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="注册" class="register">
			</td> 
		<tr>
	</table>
	</form>
	<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="../js/register.js"></script>
</body>
</html>