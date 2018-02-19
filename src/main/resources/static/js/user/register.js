/**
 * 注册方式切换
 */
$(".title_ul li").click(function(){
	$(this).siblings().removeClass("choose_li")
	$(this).addClass("choose_li")
	$(".login_ul").hide();
	$("."+ $(this).attr("tabindex")).show();
})
/**
 * 注册方法
 */
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
