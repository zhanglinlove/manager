$(function(){
	leftLoad();
});

$('.default-top .search').click(function(){
	var content = $('.default-top .middle .content').val();
	$.ajax({
		url: 'http://localhost:8080/searchInfo',
		type: 'post',
		data: {name: content},
		dataType: 'json',
		beforeSend: function(){
			if (content === null || content == '')
				return false;
			return true;
		},
		error: function(XMLHttpRequest){
			alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
		},
		success: function(data){
			if (data !== undefined && data !== null){
				var obj = eval(data);
				if (obj.list !== undefined && obj.list !== null){
					var str = "<ul>";
					$.each(obj.list,function(i,a){
						str += '<li><ul><li>' + a.name + '</li><li>' + a.marketprice + '</li>'
								+ '<li>' + a.sellprice + '</li><li><a data="' + a.id + '"><span>加入购物车</span></a></li></ul></li>';
					});
					str += '</ul>';
				}
				
				$('.default-main').empty();
				$('.default-main').html(str);
			}
		}
	});
});

$(document).on('click','span', function(){

	var id = $('.default-main a').attr('data');
	alert('id='+id);
	$.ajax({
		url: 'http://localhost:8080/addCartInfo',
		type: 'post',
		data: {'id': id},
		dataType: 'json',
		error: function(XMLHttpRequest){
			alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
		},
		success: function(data){
			if (data !== undefined && data !== null){
				var obj = eval(data);
				var cart = obj.cart;
				var str = '<ul><li>商品名称</li><li>商品价格</li><li>数量</li>';
				if (cart != null){
					$.each(cart,function(i,a){
						str += '<li>' + a.name + '</li><li>'+ a.price + '</li><li>' + a.num + '</li>';
					});
					str += '</ul>';
				}
				$('.default-right .banner .cart').empty();
				$('.default-right .banner .cart').html(str);
			}
		}
	});
});

$('.banner ul li:first-child').click(function(){
	var s = $('.banner').css('right');
	if (s == '0px'){
		$('.banner').animate({right:'-270px'},'slow');
	} else {
		$('.banner').animate({right:'0px'},'slow');
		$('.banner .cart').css('right','0px');
	}
});

function leftLoad(){
	$.ajax({
		url: 'http://localhost:8080/sellselect',
		type: 'get',
		dataType: 'json',
		error: function(XMLHttpRequest){
			alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
		},
		success: function(data){
			if (data !== undefined && data !== null){
				var obj = eval(data);
				var sells = obj.sells;
				var popularity = obj.popularity;
				var recommend = obj.recommend;
				var cart = obj.cart;
				
				var str1 = "<ul>";
				var str2 = "<ul>";
				var str3 = "<ul>";
				var str4 = '<ul><li>商品名称</li><li>商品价格</li><li>数量</li>';
				
				if (sells !== undefined && sells !== null){
					$.each(sells,function(i,a){
						str1 += '<li>' + a.name + '</li>';
					});
					str1 += '</ul>';
				}
				if (popularity !== undefined && popularity !== null){
					$.each(popularity,function(i,a){
						str2 += '<li>' + a.name + '</li>';
					});
					str2 += '</ul>';
				}
				if (recommend !== undefined && recommend !== null){
					$.each(recommend,function(j,b){
						str3 += '<li>' + b.name + '</li>';
					});
					str3 += '</ul>';
				}
				if (cart !== undefined && cart !== null){
					$.each(cart,function(i,a){
						str4 += '<li>' + a.name + '</li><li>'+ a.price + '</li><li>' + a.num + '</li>';
					});
					str4 += '</ul>';
				}
				
				$('.default-left .first').empty();
				$('.default-left .first').html(str1);
				
				$('.default-left .second').empty();
				$('.default-left .second').html(str2);
				
				$('.default-left .third').empty();
				$('.default-left .third').html(str3);
				
				$('.default-right .banner .cart').empty();
				$('.default-right .banner .cart').html(str4);
			}
		}
	});
}

$('.default a').click(function(){
	self.location.href='http://localhost:8080/user/logout';
});
