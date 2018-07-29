$(function(){
    
})

$('#login').click(function(){
    var jsondata = {
            username: $('#name').val(),
            realName: $('#realname').val()
    };
    alert(JSON.stringify(jsondata));
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/cart/login',
        data: JSON.stringify(jsondata),
        dataType: 'JSON',
        contentType: 'application/json',
        async: true,
        beforeSend: check,
        error: function(data){
            alert("data="+data);
        },
        success: function(data) {
            if(data!==null&&data!=undefined){
                if(data.status!=null&&data.status!=undefined&&String(data.status)!=='')
                self.location.href = 'http://localhost:8080/cart/page/business/default.html';
            }
        }
    })
})

function check() {
    var name = $('#name').val();
    var realname = $('#realname').val();
    if(name==null||$.trim(name)==''){
        alert("不能为空");
        return false;
    }
        
    if(realname==null||$.trim(realname)=='') {
        alert("不能为空");
        return false;
    }
        
    return true;
}