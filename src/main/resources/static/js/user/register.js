$("#loginBtn").click(function(){
	var account = $("#account").val();
	var pwd = $("#pwd").val();
	$.ajax({
		type:"post",
		url:"/userRest/reg",
		data:{
			"po.account":account,
			"po.pwd":pwd
		},
		success:function(data){
			alert(data.msg)
		}
	});
})
