<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="select_cont">
		<span>商品名称：<input type="text" name="shopname" class="shopname"></span>
		<input type="button" value="查询" class="query">
	</div>
	<div class="select_show">
	
	</div>
	<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url: 'http://localhost:8080/categoryall',
				type: 'post',
				dataType: 'json',
				error: function(XMLHttpRequest){
					alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
				},
				success: function(data){
					if (data != undefind && data != null){
						var obj = eval(data);
						var str = '<select class="option">';
						$(obj).each(function(i,a){
							str += '<option value="'+a.id+'">'+a.name + '</option>';
						});
						str += '</select>';
						$('.select_cont').insertBefore($('.option'), $('.select_cont span'));
					}
				}
			});
		})
		$('.query').click(function(){
			var op = $('.select_cont .option').val();
			var name = $('.select_cont .shopname').val();
			var parameter = {
					name: name,
					categoryid: op
			};
			$.ajax({
				url: 'http://localhost:8080/searchInfo',
				type: 'post',
				data: parameter,
				dataType: 'json',
				error: function (XMLHttpRequest){
					alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
				},
				success: function(data){
					if (data != undefind && data != null){
						var obj = eval(data);
						var str = '<table><tr><td>商品名称</td><td>采购价格</td><td>市场价格</td><td>销售价格</td>'
						+ '<td>修改</td><td>删除</td></tr> ';
						$(obj).each(function(a,i){
							str += '<td>'+a.name + '</td><td>'+a.baseprice + '</td><td>'+  a.marketprice+'</td><td>'
									+ a.sellprice + '</td><td><span data="'+ a.id +'" class="s1">'+ 修改  +'</span></td><td><span data="'+ a.id
									+ '" class="s2">'+ 删除+'</span></td></tr>';
						});
						str += '</table>';
						$('.select_show').empty();
						$('.select_show').html(str);
					}
				}
			});
		});
		
		$('.select_show .s1').click(function(){
			var id = $(this).attr(data);
			self.location.href = 'http://localhost:8080/';
		});
		$('.select_show .s2').click(function(){
			var id = $(this).attr(data);
			self.location.href = 'http://localhost:8080/';
		});
	</script>
</body>
</html>