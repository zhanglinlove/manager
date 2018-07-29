<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<textarea rows="6" cols="60" class="t"></textarea>
	<br>
	<input type="button" value="生成" class="proc">
	<br>
	<textarea rows="6" cols="60" class="sql"></textarea>
	<br>
	<input type="button" value="查询" class="select">
	<br>
	<div class="content">
	</div>
	<script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
		$('.proc').click(function(){
			var s = $('.t').val();
			var sql = $('.sql').val(s);
		})
		$('.select').click(function(){
			var sql = $('.sql').val();
			var parameter = {sql: sql};
			$.ajax({
				url : 'http://localhost:8080/test',
				type: 'post',
				data: parameter,
				dataType: 'json',
				error: function(XMLHttpRequest){
					alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
				},
				success: function(data){
					if (data !== undefined && data !== null){
						alert(data);
						var obj = eval(data);
						var str = '<table>';
						if (obj.info != null && obj.info != ''){
							$.each(obj.info,function(i,a){
								str += '<tr>';
								$.each(a,function(j,b){
									str += '<td>' + b + '</td>';
								})
								str += '</tr>';
							});
						}
						str += '</table>';
						$('.content').html(str);
					}
				}
			});
		})
	</script>
</body>
</html>