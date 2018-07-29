$(function(){
	
});

$(".register").click(function(){
	var name = $(".username").val();
	var pwd = $(".password").val();
	var pwd2 = $(".pwd2").val();
	if ((pwd == pwd2) && $.trim(name) != '' && $.trim(pwd) != '' )
		return true;
	
	return false;
});