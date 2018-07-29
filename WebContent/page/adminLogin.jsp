<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user/adminlogin" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" class="username"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" class="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提交" class="sub">
			</td>
		</tr>
	</table>
</form>

<script src="../../js/jquery-1.10.2.min.js"></script>
<script>
	$('.sub').click(function(){
		var username = $('.username').val();
		var password = $('.password').val();
		if ($.trim(username) == '' || $.trim(password) == '')
			return false;
		return true;
	});
</script>
</body>
</html>