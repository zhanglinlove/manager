<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/updateshop" method="post">
		<table>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name" value="${info.name }"></td>
			</tr>
			<tr>
				<td>商品描述：</td>
				<td><input type="text" name="description" style="width:120px;" value="${info.description }"></td>
			</tr>
			<tr>
				<td>采购价格：</td>
				<td><input type="text" name="baseprice" value="${info.baseprice }"></td>
			</tr>
			<tr>
				<td>市场价格：</td>
				<td><input type="text" name="marketprice" value="${info.marketprice }"></td>
			</tr>
			<tr>
				<td>销售价格：</td>
				<td><input type="text" name="sellerprice" value="${info.sellerprice }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" value="${info.id }">
					<input type="submit" value="新增" class="sub">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>