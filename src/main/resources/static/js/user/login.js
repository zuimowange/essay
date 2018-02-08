$("#loginBtn").click(function(){
	var account = $("#account").val();
	var pwd = $("#pwd").val();
	$.ajax({
		type:"post",
		url:"/userRest/login",
		data:{
			"po.account":account,
			"po.pwd":pwd
		},
		success:function(data){
			CookieUtil.set("token",data.token);
			alert(data.msg);
		}
	});
})
