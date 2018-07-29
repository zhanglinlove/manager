$(function () {
    getInfo();
})

function getInfo() {
    var jsondata = {};
    $.ajax({
        type: 'POST',
        data: JSON.stringify(jsondata),
        url: 'http://localhost:8080/cart/selectMenuList',
        dataType: 'JSON',
        contentType: 'application/json',
        async: true,
        error: function(data) {
            alert("data="+data);
        },
        success: function(data) {
            if(data!==null&&data!==undefined){
                if(data.status!==null&&data.status!=undefined&&String(data.status)!=''){
                    var obj = eval(data);
                    var str = '<table>';
                    if(data.list!==null&&data.list!==undefined){
                        $.each(obj.list, function(i,a) {
                            str +='<ul><li onclick="select("'+a.url+')">'+a.name+'</td>';
                        }); 
                        str +='</table>';
                    }
                    
                    $('#content').empty();
                    $('#content').append(str);
                }
            }else{
                alert("this is a error!");
            }
        }
    })
}

function select(url) {
    if(url==null||url==''){
        $('#main').attr('src','');
    }else{
        $('#main').attr('src',url);
    }
}
$('.left ul li a').click(function(){
	var url = $(this).attr('data');
	$.ajax({
		url: url,
		type: 'get',
		dataType: 'json',
		error: function(XMLHttpRequest){
			alert(XMLHttpRequest.status+";"+XMLHttpRequest.readyState);
		},
		success: function(data){
			if (data !== undefined && data !== null){
				$('.cotent').html(data);
			}
		}
	});
});