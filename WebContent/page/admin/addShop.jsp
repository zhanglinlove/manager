<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form" action="/addshop" method="post">
		<table>
			<tr>
				<td>商品名称：</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>商品描述：</td>
				<td><input type="text" name="description" id="description" style="width:120px;"></td>
			</tr>
			<tr>
				<td>采购价格：</td>
				<td><input type="text" name="baseprice" id="baseprice"></td>
			</tr>
			<tr>
				<td>市场价格：</td>
				<td><input type="text" name="marketprice" id="marketprice"></td>
			</tr>
			<tr>
				<td>销售价格：</td>
				<td><input type="text" name="sellerprice" id="sellerprice"></td>
			</tr>
			<tr>
				<td>类别：</td>
				<td>
					<span class="category"></span>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="新增" class="sub">
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			loadInfo();
			});
		
		$('.sub').click(function(){
			var s = $('#select').val();
			var name = $("#name").val();
			var description = $("#description").val();
			var baseprice = $("#baseprice").val();
			var marketprice = $("#marketprice").val();
			var sellerprice = $("#sellerprice").val();
			if (s == null || $.trim(name) === '' || $.trim(baseprice) === '' 
					|| $.trim(marketprice) === '' || $.trim(sellerprice) ==='')
				return false;
			/* var param = {
				name: name,
				description: description,
				baseprice: baseprice,
				marketprice: marketprice,
				sellerprice: sellerprice,
				categoryid: s
			};
			$.ajax({
				
			}) */
		})
		
		function loadInfo(){
			$.ajax({
				url: 'http://localhost:8080/categoryall',
				type: 'get',
				dataType: 'json',
				error: function(XMLHttpRequest){
					alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
				},
				success: function(data){
					if (data != undefined && data !== null){
						var obj = eval(data);
						var str = '<select id = "select" name="categoryid">';
						$.each(obj.list, function(i,a){
							str += '<option value=' + a.id + '>' + a.name + '</option>';
						})
						str += '</option>';
						$('.category').html(str);
					}
				}
			})
		}
	</script>
</body>
</html>